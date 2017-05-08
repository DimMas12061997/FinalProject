package dao;

import entities.Bean;
import exceptions.DaoException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.io.Serializable;
import java.util.List;


public abstract class BaseDao<T extends Bean> implements IBaseDao<T> {

    protected HibernateUtil hibernateUtil;
    private Class<T> persistentClass;

    @Override
    public List<T> getAll() {
        List<T> results;
        try {
            Session session = hibernateUtil.getSession();
            Criteria criteria = session.createCriteria(persistentClass);
            results = criteria.list();

        } catch (Exception e) {
            throw new DaoException("Error was thrown in DAO");
        }
        return results;
    }


    @Override
    public Serializable save(T entity) throws DaoException{
        Serializable id;
        try {
            Session session = hibernateUtil.getSession();
            session.saveOrUpdate(entity);
            id = session.getIdentifier(entity);
        }
        catch(HibernateException e) {
            throw new DaoException("Error was thrown in DAO");
        }
        return id;
    }

    @Override
    public T getById(int id) {
        T entity;
        try {
            Session session = hibernateUtil.getSession();
            entity = (T) session.get(persistentClass, id);
        } catch (HibernateException e) {
            throw new DaoException("Error was thrown in DAO");
        }
        return entity;
    }

    @Override
    public void update(T entity) {
        try {
            Session session = hibernateUtil.getSession();
            session.update(entity);
        } catch (HibernateException e) {
            throw new DaoException("Error was thrown in DAO");
        }
    }

    @Override
    public void delete(int id) {
        try {
            Session session = hibernateUtil.getSession();
            T entity = (T) session.get(persistentClass, id);
            session.delete(entity);
        } catch (HibernateException e) {
            throw new DaoException("Error was thrown in DAO");
        }
    }


    public BaseDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        hibernateUtil = HibernateUtil.getInstance();
    }
}
