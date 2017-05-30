package by.masalsky.onlineshop.services.impl;


import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.dao.interfaces.IBaseDao;
import by.masalsky.onlineshop.entities.Bean;
import by.masalsky.onlineshop.exceptions.ServiceException;
import by.masalsky.onlineshop.services.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class AbstractService<T extends Bean> implements IService<T> {
    private final static Logger logger = LoggerFactory.getLogger(AbstractService.class);
    private IBaseDao<T> dao;

    protected AbstractService(IBaseDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public int save(T entity){
        int id = 0;
        try {
            id = dao.save(entity);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return id;
    }

    @Override
    public List<T> getAll() {
        List<T> users = null;
        if (logger.isDebugEnabled()) {
            logger.debug(ServiceConstants.TRANSACTION_DEBUG);
        }
        try {
            users = dao.getAll();
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return users;
    }

    @Override
    public T getById(int id) {
        T user = null;
        try {
            user = dao.getById(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return user;
    }

    @Override
    public void update(T entity) {
        try {
            dao.update(entity);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }
}
