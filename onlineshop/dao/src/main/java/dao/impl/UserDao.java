package dao.impl;

import constants.Queries;
import dao.BaseDao;
import dao.IUserDao;
import entities.User;
import exceptions.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDao extends BaseDao<User> implements IUserDao {

    public UserDao(Class<User> persistentClass) {
        super(persistentClass);
    }

    @Override
    public User getByLogin(String login) {
        User user;
        try {
            Session session = hibernateUtil.getSession();
            Query query = session.createQuery(Queries.GET_BY_LOGIN);
            query.setParameter("login", login);
            user = (User) query.uniqueResult();
        } catch (HibernateException e) {
            throw new DaoException("Unable to return user by login. Error was thrown in DAO");
        }
        return user;
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        boolean isLogIn = false;
        try {
            Session session = hibernateUtil.getSession();
            Query query = session.createQuery(Queries.CHECK_AUTHORIZATION);
            query.setParameter("login", login);
            query.setParameter("password", password);
            if (query.uniqueResult() != null) {
                isLogIn = true;
            }
        } catch (HibernateException e) {
            throw new DaoException("Unable to check authorization. Error was thrown in DAO: ");
        }
        return isLogIn;
    }
}
