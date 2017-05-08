package dao.impl;


import dao.BaseDao;
import dao.IOrderDao;
import entities.Order;

public class OrderDao  extends BaseDao<Order> implements IOrderDao {

    public OrderDao(Class<Order> persistentClass) {
        super(persistentClass);
    }

}
