package by.masalsky.onlineshop.dao;

import by.masalsky.onlineshop.constants.DaoConstants;
import by.masalsky.onlineshop.entities.Bean;
import by.masalsky.onlineshop.exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class BaseDao<T extends Bean> implements IBaseDao<T> {
    private static Logger logger = LoggerFactory.getLogger(BaseDao.class);
    private Class persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    protected BaseDao(Class persistentClass, SessionFactory sessionFactory){
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getAll() {
        List<T> results = null;
        try {
            Session session = getCurrentSession();
            Criteria criteria = session.createCriteria(persistentClass);
            results = criteria.list();

        } catch (Exception e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return results;
    }


    @Override
    public int save(T entity) throws DaoException{
        int id = 0;
        try {
            Session session = getCurrentSession();
            session.save(entity);
            id = (int) session.getIdentifier(entity);
        }
        catch(HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return id;
    }

    @Override
    public T getById(int id) {
        T entity = null;
        try {
            Session session = getCurrentSession();
            entity = (T) session.get(persistentClass, id);
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return entity;
    }

    @Override
    public void update(T entity) {
        try {
            Session session = getCurrentSession();
            session.update(entity);
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Session session = getCurrentSession();
            T entity = (T) session.get(persistentClass, id);
            session.delete(entity);
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
    }

}
