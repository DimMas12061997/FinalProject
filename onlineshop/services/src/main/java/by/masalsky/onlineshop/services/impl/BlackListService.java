package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.converters.Converter;
import by.masalsky.onlineshop.dao.interfaces.IBlackListDao;
import by.masalsky.onlineshop.dao.interfaces.IGoodsDao;
import by.masalsky.onlineshop.dao.interfaces.IOrderDao;
import by.masalsky.onlineshop.dao.interfaces.IUserDao;
import by.masalsky.onlineshop.dto.BlackListDto;
import by.masalsky.onlineshop.dto.OrderDto;
import by.masalsky.onlineshop.entities.BlackList;
import by.masalsky.onlineshop.entities.Goods;
import by.masalsky.onlineshop.entities.Order;
import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.enums.RoleType;
import by.masalsky.onlineshop.exceptions.ServiceException;
import by.masalsky.onlineshop.services.interfaces.IBlackListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BlackListService implements IBlackListService {
    @Autowired
    private IBlackListDao blackListDao;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IOrderDao orderDao;
    @Autowired
    private IGoodsDao goodsDao;
    private final static Logger logger = LoggerFactory.getLogger(BlackListService.class);

    @Override
    public int save(BlackListDto blackListDto) {
        User user = null;
        Order order = null;
        BlackList blackList = Converter.blackListDtoToBlackList(blackListDto);
        int id = 0;
        try {
            user = userDao.getById(blackListDto.getUser());
            order = orderDao.getByUserId(blackListDto.getUser());
            if (order != null && user.getRole().getRole_name().equals(RoleType.CLIENT)) {
                id = blackListDao.save(blackList);
                OrderDto orderDto = Converter.orderToOrderDto(order);
                for (Goods goodsTmp : order.getGoodsList())
                    orderDto.setGoodsId(goodsTmp.getId());
                Goods goods = goodsDao.getById(orderDto.getGoodsId());
                goods.setNumber(goods.getNumber() + order.getNumber());
                goodsDao.update(goods);
                orderDao.delete(order.getId());
            } else
                id = -1;
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return id;
    }

    @Override
    public List<BlackListDto> getAll() {
        List<BlackList> blackList = null;
        BlackListDto blackListDto = null;
        List<BlackListDto> blackListDtoList = new ArrayList<BlackListDto>();
        try {
            blackList = blackListDao.getAll();
            for (BlackList blacklistTmp : blackList) {
                blackListDto = Converter.blackListToBlackListDto(blacklistTmp);
                blackListDtoList.add(blackListDto);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return blackListDtoList;
    }

    @Override
    public BlackListDto getById(int id) {
        BlackList blackList = null;
        BlackListDto blackListDto = null;
        try {
            blackList = blackListDao.getById(id);
            if (blackList != null)
                blackListDto = Converter.blackListToBlackListDto(blackList);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return blackListDto;
    }

    @Override
    public void update(BlackListDto entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        try {
            blackListDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }
}
