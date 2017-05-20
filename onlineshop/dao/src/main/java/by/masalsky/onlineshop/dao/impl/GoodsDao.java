package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.constants.DaoConstants;
import by.masalsky.onlineshop.dao.BaseDao;
import by.masalsky.onlineshop.exceptions.DaoException;
import by.masalsky.onlineshop.dao.IGoodsDao;
import by.masalsky.onlineshop.entities.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDao extends BaseDao<Goods> implements IGoodsDao {
    private static Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private GoodsDao(SessionFactory sessionFactory){
        super(Goods.class, sessionFactory);
    }


    @Override
    public List<Goods> findAllSortByPrice() {
        List<Goods> results = null;
        try {
            Session session = getCurrentSession();
            results = session.createCriteria(Goods.class)
                    .addOrder(Order.desc("id"))
                    .list();

        } catch (Exception e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return results;
    }
}

