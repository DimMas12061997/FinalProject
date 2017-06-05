package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.constants.DaoConstants;
import by.masalsky.onlineshop.constants.Queries;
import by.masalsky.onlineshop.dao.interfaces.IBlackListDao;
import by.masalsky.onlineshop.entities.BlackList;
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
public class BlackListDao extends BaseDao<BlackList> implements IBlackListDao {
    private static Logger logger = LoggerFactory.getLogger(BlackListDao.class);

    @Autowired
    private BlackListDao(SessionFactory sessionFactory){
        super(BlackList.class, sessionFactory);
    }

    @Override
    public BlackList getByUserId(int id) {
        BlackList user = null;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.GET_BY_USER_ID_FROM_BLACKLIST);
            query.setParameter("id", id);
            user = (BlackList) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return user;
    }
}
