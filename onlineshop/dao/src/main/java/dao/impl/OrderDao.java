package dao.impl;


import dao.BaseDao;
import dao.IOrderDao;
import entities.Order;
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
