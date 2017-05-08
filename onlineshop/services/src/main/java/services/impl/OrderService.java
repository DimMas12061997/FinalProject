package services.impl;


import entities.Order;
import services.AbstractService;
import services.IOrderService;

import java.io.Serializable;
import java.util.List;

public class OrderService extends AbstractService<Order> implements IOrderService {

    public Serializable save(Order entity) {
        return null;
    }

    public List<Order> getAll() {
        return null;
    }

    public Order getById(int id) {
        return null;
    }

    public void update(Order entity) {

    }

    public void delete(int id) {

    }
}
