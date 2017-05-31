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
        Goods goods = Converter.goodsDtoToGoods(goodsDto);
        int id = 0;
        try {
            id = goodsDao.save(goods);
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
        List<GoodsDto> usersDto = new ArrayList<GoodsDto>();
        if (logger.isDebugEnabled()) {
            logger.debug(ServiceConstants.TRANSACTION_DEBUG);
        }
        try {
            goodsList = goodsDao.getAll();
            for (Goods goods : goodsList) {
                goodsDto = Converter.goodsToGoodsDto(goods);
                usersDto.add(goodsDto);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return usersDto;
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
    public void update(GoodsDto entity) {

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

