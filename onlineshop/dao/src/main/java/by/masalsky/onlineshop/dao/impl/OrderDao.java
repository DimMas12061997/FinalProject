package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.constants.DaoConstants;
import by.masalsky.onlineshop.constants.Queries;
import by.masalsky.onlineshop.dao.interfaces.IOrderDao;
import by.masalsky.onlineshop.entities.Order;
import by.masalsky.onlineshop.exceptions.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao  extends BaseDao<Order> implements IOrderDao {
    private final static Logger logger = LoggerFactory.getLogger(OrderDao.class);

    @Autowired
    private OrderDao(SessionFactory sessionFactory){
        super(Order.class, sessionFactory);
    }


    @Override
    public Order getByUserId(int id) {
        Order user = null;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.GET_BY_USER_ID_FROM_ORDER);
            query.setParameter("id", id);
            user = (Order) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return user;
    }
}
