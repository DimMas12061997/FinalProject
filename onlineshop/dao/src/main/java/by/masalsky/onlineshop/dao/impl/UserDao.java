package by.masalsky.onlineshop.dao.impl;

import by.masalsky.onlineshop.dao.BaseDao;
import by.masalsky.onlineshop.constants.DaoConstants;
import by.masalsky.onlineshop.constants.Queries;
import by.masalsky.onlineshop.dao.IUserDao;
import by.masalsky.onlineshop.entities.User;
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
public class UserDao extends BaseDao<User> implements IUserDao {
    private static Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private UserDao(SessionFactory sessionFactory){
        super(User.class, sessionFactory);
    }

    @Override
    public User getByLogin(String login) {
        User user = null;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.GET_BY_LOGIN);
            query.setParameter("login", login);
            user = (User) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return user;
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        boolean isLogIn = false;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.CHECK_AUTHORIZATION);
            query.setParameter("login", login);
            query.setParameter("password", password);
            if (query.uniqueResult() != null) {
                isLogIn = true;
            }
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return isLogIn;
    }
}
