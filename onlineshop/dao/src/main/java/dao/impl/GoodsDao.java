package dao.impl;


import dao.BaseDao;
import dao.IGoodsDao;
import entities.Goods;

public class GoodsDao extends BaseDao<Goods> implements IGoodsDao {

    public GoodsDao(Class<Goods> persistentClass) {
        super(persistentClass);
    }

}

