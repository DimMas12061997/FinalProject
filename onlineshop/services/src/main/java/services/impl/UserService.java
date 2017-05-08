package services.impl;

import dao.IUserDao;
import dao.impl.UserDao;
import entities.User;
import exceptions.DaoException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import services.AbstractService;
import services.IUserService;

import java.io.Serializable;
import java.util.List;

public class UserService extends AbstractService<User> implements IUserService {
    private IUserDao userDao = new UserDao(User.class);

    @Override
    public User getByLogin(String login) {
        User user;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user = userDao.getByLogin(login);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DaoException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return user;
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        return false;
    }


    @Override
    public Serializable save(User entity) throws ServiceException {
        Serializable id;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            id = userDao.save(entity);
            transaction.commit(); System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DaoException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return id;
    }

    @Override
    public List<User> getAll() {
        List<User> users;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            users = userDao.getAll();
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DaoException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return users;
    }

    @Override
    public User getById(int id) {
        User user;
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            user = userDao.getById(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DaoException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
        return user;
    }

    @Override
    public void update(User entity) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            userDao.update(entity);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DaoException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }

    @Override
    public void delete(int id) {
        Session session = hibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            userDao.delete(id);
            transaction.commit();
            System.out.println(TRANSACTION_SUCCEEDED);
        }
        catch (DaoException e) {
            transaction.rollback();
            throw new ServiceException(TRANSACTION_FAILED + e);
        }
    }
}
