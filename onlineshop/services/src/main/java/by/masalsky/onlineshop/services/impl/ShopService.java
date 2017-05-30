package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.dao.interfaces.IShopDao;
import by.masalsky.onlineshop.dao.impl.ShopDao;
import by.masalsky.onlineshop.entities.OnlineShop;
import by.masalsky.onlineshop.services.interfaces.IShopService;
import org.springframework.beans.factory.annotation.Autowired;


public class ShopService extends AbstractService<OnlineShop> implements IShopService {

    private IShopDao shopDao;

    @Autowired
    public ShopService(ShopDao shopDao) {
        super(shopDao);
        this.shopDao = shopDao;
    }
}
