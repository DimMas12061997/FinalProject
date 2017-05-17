package dao.impl;

import dao.BaseDao;
import dao.IShopDao;
import entities.OnlineShop;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDao extends BaseDao<OnlineShop> implements IShopDao {

    @Autowired
    private ShopDao(SessionFactory sessionFactory){
        super(OnlineShop.class, sessionFactory);
    }

}
