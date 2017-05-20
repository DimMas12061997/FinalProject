package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.dao.BaseDao;
import by.masalsky.onlineshop.dao.IOrderDao;
import by.masalsky.onlineshop.entities.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao  extends BaseDao<Order> implements IOrderDao {

    @Autowired
    private OrderDao(SessionFactory sessionFactory){
        super(Order.class, sessionFactory);
    }


}
