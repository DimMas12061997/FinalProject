package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.dao.IShopDao;
import by.masalsky.onlineshop.dao.impl.ShopDao;
import by.masalsky.onlineshop.entities.OnlineShop;
import by.masalsky.onlineshop.services.AbstractService;
import by.masalsky.onlineshop.services.IShopService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ShopService extends AbstractService<OnlineShop> implements IShopService {

    private IShopDao shopDao;

    @Autowired
    public ShopService(ShopDao shopDao) {
        super(shopDao);
        this.shopDao = shopDao;
    }

    public int save(OnlineShop entity) {
        return 0;
    }

    public List<OnlineShop> getAll() {
        return null;
    }

    public OnlineShop getById(int id) {
        return null;
    }

    public void update(OnlineShop entity) {

    }

    public void delete(int id) {

    }
}
