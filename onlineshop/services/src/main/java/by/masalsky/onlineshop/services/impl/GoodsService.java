package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.converters.Converter;
import by.masalsky.onlineshop.dao.interfaces.IGoodsDao;
import by.masalsky.onlineshop.dto.GoodsDto;
import by.masalsky.onlineshop.entities.Goods;
import by.masalsky.onlineshop.exceptions.ServiceException;
import by.masalsky.onlineshop.services.interfaces.IGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GoodsService implements IGoodsService {

    @Autowired
    private IGoodsDao goodsDao;
    private final static Logger logger = LoggerFactory.getLogger(GoodsService.class);

    @Override
    public int save(GoodsDto goodsDto) {
        int id = 0, flag = 0;
        try {
            Goods goods = Converter.goodsDtoToGoods(goodsDto);
            List<Goods> goodsList = goodsDao.getAll();
            for (Goods goodsTmp : goodsList)
                if (goodsTmp.getName().equals(goods.getName()) && goodsTmp.getUnitPrice() == goods.getUnitPrice() && goodsTmp.getProducer().equals(goods.getProducer()) && goodsTmp.getDescription().equals(goods.getDescription())) {
                    flag++;
                    goods.setNumber(goods.getNumber() + goodsTmp.getNumber());
                }
            if (flag == 0)
                id = goodsDao.save(goods);
            else {
                goodsDao.update(goods);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return id;
    }

    @Override
    public List<GoodsDto> getAll() {
        List<Goods> goodsList = null;
        GoodsDto goodsDto = null;
        List<GoodsDto> goodsDtoList = new ArrayList<GoodsDto>();
        try {
            goodsList = goodsDao.getAll();
            for (Goods goods : goodsList) {
                goodsDto = Converter.goodsToGoodsDto(goods);
                goodsDtoList.add(goodsDto);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return goodsDtoList;
    }

    @Override
    public GoodsDto getById(int id) {
        Goods goods = null;
        GoodsDto goodsDto = null;
        try {
            goods = goodsDao.getById(id);
            if (goods != null)
                goodsDto = Converter.goodsToGoodsDto(goods);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return goodsDto;
    }

    @Override
    public void update(GoodsDto goodsDto) {
        Goods goods = Converter.goodsDtoToGoods(goodsDto);
        try {
            goodsDao.update(goods);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (org.hibernate.service.spi.ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            goodsDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (org.hibernate.service.spi.ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }
}

