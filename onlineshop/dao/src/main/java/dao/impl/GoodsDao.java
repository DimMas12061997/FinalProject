package dao.impl;


import dao.BaseDao;
import dao.IGoodsDao;
import entities.Goods;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDao extends BaseDao<Goods> implements IGoodsDao {

    @Autowired
    private GoodsDao(SessionFactory sessionFactory){
        super(Goods.class, sessionFactory);
    }


}

