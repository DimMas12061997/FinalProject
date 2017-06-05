package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.converters.Converter;
import by.masalsky.onlineshop.dao.interfaces.*;
import by.masalsky.onlineshop.dto.OrderDto;
import by.masalsky.onlineshop.entities.Goods;
import by.masalsky.onlineshop.entities.OnlineShop;
import by.masalsky.onlineshop.entities.Order;
import by.masalsky.onlineshop.entities.UserProfile;
import by.masalsky.onlineshop.exceptions.ServiceException;
import by.masalsky.onlineshop.services.interfaces.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class OrderService implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private IGoodsDao goodsDao;
    @Autowired
    private IUserProfileDao userProfileDao;
    @Autowired
    private IShopDao shopDao;
    @Autowired
    private IBlackListDao blackListDao;
    private final static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Override
    public int save(OrderDto orderDto) {
        int id = 0, flag = 0, number = 0;
        OrderDto orderDtoTmp = null;
        Order orderForUpdate = null;
        try {
            if (blackListDao.getByUserId(orderDto.getUserId()) == null) {
                Order order = Converter.orderDtoToOrder(orderDto);
                Goods goods = goodsDao.getById(orderDto.getGoodsId());
                for (Order orderTmp : orderDao.getAll()) {
                    orderDtoTmp = Converter.orderToOrderDto(orderTmp);
                    for (Goods goodsTmp : orderTmp.getGoodsList())
                        orderDtoTmp.setGoodsId(goodsTmp.getId());
                    if (orderDtoTmp.getGoodsId() == orderDto.getGoodsId() && orderDtoTmp.getUserId() == orderDto.getUserId()) {
                        flag++;
                        orderForUpdate = orderDao.getById(orderDtoTmp.getId());
                        number += orderDtoTmp.getNumber();
                    }
                }
                if (goods.getNumber() >= orderDto.getNumber()) {
                    goods.setNumber(goods.getNumber() - orderDto.getNumber());
                    goodsDao.update(goods);
                    Set<Goods> goodsSet = new HashSet<Goods>();
                    goodsSet.add(goods);
                    order.setGoodsList(goodsSet);
                    if (flag == 0) {
                        order.setOrderCost(orderDto.getNumber() * goods.getUnitPrice());
                        id = orderDao.save(order);
                    } else {
                        orderForUpdate.setNumber(orderDto.getNumber() + number);
                        orderForUpdate.setOrderCost(orderForUpdate.getNumber() * goods.getUnitPrice());
                        orderDao.update(orderForUpdate);
                    }
                    logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
                } else
                    id = -1;
            } else
                id = -2;
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return id;
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orderList = null;
        OrderDto orderDto = null;
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
        Set<String> orderSet = new HashSet<String>();
        try {
            orderList = orderDao.getAll();
            for (Order goods : orderList) {
                orderDto = Converter.orderToOrderDto(goods);
                for (Goods goodsTmp : goods.getGoodsList())
                    orderDto.setGoodsId(goodsTmp.getId());
                orderDtoList.add(orderDto);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return orderDtoList;
    }

    @Override
    public OrderDto getById(int id) {
        Order order = null;
        OrderDto orderDto = null;
        try {
            order = orderDao.getById(id);
            if (order != null)
                orderDto = Converter.orderToOrderDto(order);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return orderDto;
    }

    @Override
    public void update(OrderDto orderDto) {
        int flag = 0;
        Order order = Converter.orderDtoToOrder(orderDto);
        Goods goods = goodsDao.getById(orderDto.getGoodsId());
        Order orderTmp = orderDao.getById(orderDto.getId());
        try {
            if (orderTmp.getNumber() > orderDto.getNumber()) {
                goods.setNumber(goods.getNumber() + (orderTmp.getNumber() - orderDto.getNumber()));
                goodsDao.update(goods);
            } else if (orderTmp.getNumber() < orderDto.getNumber()) {
                if (goods.getNumber() >= (orderDto.getNumber() - orderTmp.getNumber())) {
                    goods.setNumber(goods.getNumber() - (orderDto.getNumber() - orderTmp.getNumber()));
                    goodsDao.update(goods);
                } else
                    flag++;
            }
            if (flag == 0) {
                order.setOrderCost(orderDto.getNumber() * goods.getUnitPrice());
                orderDao.update(order);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (org.hibernate.service.spi.ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public void delete(int id) {
        OrderDto orderDto = null;
        Order order = orderDao.getById(id);
        if (order != null)
            orderDto = Converter.orderToOrderDto(order);
        Goods goods = goodsDao.getById(orderDto.getGoodsId());
        goods.setNumber(goods.getNumber() + order.getNumber());
        goodsDao.update(goods);
        try {
            orderDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (org.hibernate.service.spi.ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public String makePurchase() {
        List<Order> orderList = null;
        OrderDto orderDto = null;
        String info = null;
        double totalCost = 0;
        int flag = 0;
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
        try {
            orderList = orderDao.getAll();
            if (orderList.size() > 0) {
                for (Order goods : orderList) {
                    orderDto = Converter.orderToOrderDto(goods);
                    for (Goods goodsTmp : goods.getGoodsList())
                        orderDto.setGoodsId(goodsTmp.getId());
                    orderDtoList.add(orderDto);
                    if (blackListDao.getByUserId(orderDto.getUserId()) != null)
                        flag++;
                }
                if (flag == 0) {
                    for (OrderDto orderDtoTmp : orderDtoList) {
                        totalCost += orderDtoTmp.getOrderCost();
                    }
                    OnlineShop shop = shopDao.getById(1);
                    shop.setProfit(shop.getProfit() + totalCost);
                    shopDao.update(shop);
                    UserProfile userProfile = userProfileDao.getById(orderDtoList.get(1).getUserId());
                    if (userProfile != null) {
                        if (userProfile.getBudget() >= totalCost) {
                            userProfile.setBudget(userProfile.getBudget() - totalCost);
                            userProfileDao.update(userProfile);
                            for (OrderDto orderDtoDelete : orderDtoList)
                                orderDao.delete(orderDtoDelete.getId());
                            info = "You paid for the purchase!";
                            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
                        }
                        else
                            info = " You do not have enough budget!";
                    } else
                        info = "Fill user profile!";
                } else
                    info = "User is in the black list!";
            } else
                info = "You do not have an order!";
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return info;
    }

    @Override
    public OrderDto getByUserId(int id) {
        Order order = null;
        OrderDto orderDto = null;
        try {
            order = orderDao.getByUserId(id);
            if (order != null)
                orderDto = Converter.orderToOrderDto(order);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return orderDto;
    }
}
