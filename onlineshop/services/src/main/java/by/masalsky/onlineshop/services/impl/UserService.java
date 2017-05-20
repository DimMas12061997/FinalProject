package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.dao.IUserDao;
import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.exceptions.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.masalsky.onlineshop.services.AbstractService;
import by.masalsky.onlineshop.services.IUserService;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService extends AbstractService<User> implements IUserService {

    private IUserDao userDao;
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(IUserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User getByLogin(String login) {
        User user = null;
        try {
            user = userDao.getByLogin(login);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (DaoException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return user;
    }

    @Override
    @Transactional
    public boolean isAuthorized(String login, String password) {
        boolean isAuthorized = false;
        try {
            isAuthorized = userDao.isAuthorized(login, password);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (DaoException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return isAuthorized;
    }
}
