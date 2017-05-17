package services.impl;

import dao.IShopDao;
import dao.impl.ShopDao;
import entities.OnlineShop;
import org.springframework.beans.factory.annotation.Autowired;
import services.AbstractService;
import services.IShopService;

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
