package services;


import constants.ServiceConstants;
import dao.IBaseDao;
import entities.Bean;
import exceptions.DaoException;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractService<T extends Bean> implements IService<T> {
    private static Logger logger = LoggerFactory.getLogger(AbstractService.class);
    private IBaseDao<T> dao;

    protected AbstractService(IBaseDao<T> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public int save(T entity) throws ServiceException {
        int id = 0;
        try {
            id = dao.save(entity);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (DaoException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return id;
    }

    @Override
    @Transactional
    public List<T> getAll() {
        List<T> users = null;
        if (logger.isDebugEnabled()) {
            logger.debug(ServiceConstants.TRANSACTION_DEBUG);
        }
        try {
            users = dao.getAll();
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (DaoException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return users;
    }

    @Override
    @Transactional
    public T getById(int id) {
        T user = null;
        try {
            user = dao.getById(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (DaoException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return user;
    }

    @Override
    @Transactional
    public void update(T entity) {
        System.out.println(entity);
        try {
            dao.update(entity);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (DaoException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            dao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (DaoException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }
}
