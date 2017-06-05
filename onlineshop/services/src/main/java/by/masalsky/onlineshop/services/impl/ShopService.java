package by.masalsky.onlineshop.services.impl;


import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.converters.Converter;
import by.masalsky.onlineshop.dao.interfaces.IShopDao;
import by.masalsky.onlineshop.dto.OnlineShopDto;
import by.masalsky.onlineshop.entities.OnlineShop;
import by.masalsky.onlineshop.exceptions.ServiceException;
import by.masalsky.onlineshop.services.interfaces.IShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShopService implements IShopService {
    private final static Logger logger = LoggerFactory.getLogger(ShopService.class);

    @Autowired
    private IShopDao shopDao;

    @Override
    public int save(OnlineShopDto entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<OnlineShopDto> getAll() {
        List<OnlineShop> shopList = null;
        OnlineShopDto shopDto = null;
        List<OnlineShopDto> shopDtoList = new ArrayList<OnlineShopDto>();
        try {
            shopList = shopDao.getAll();
            for (OnlineShop shop : shopList) {
                shopDto = Converter.shopToShopDto(shop);
                shopDtoList.add(shopDto);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return shopDtoList;
    }

    @Override
    public OnlineShopDto getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(OnlineShopDto entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
