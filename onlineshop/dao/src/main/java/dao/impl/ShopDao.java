package dao.impl;

import dao.BaseDao;
import dao.IShopDao;
import entities.OnlineShop;


public class ShopDao extends BaseDao<OnlineShop> implements IShopDao {

    public ShopDao(Class<OnlineShop> persistentClass) {
        super(persistentClass);
    }

}
