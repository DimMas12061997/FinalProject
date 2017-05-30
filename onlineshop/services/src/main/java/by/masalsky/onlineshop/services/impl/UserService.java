package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.converters.Converter;
import by.masalsky.onlineshop.dao.interfaces.IUserDao;
import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.services.interfaces.IUserService;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService extends AbstractService<User> implements IUserService {

    private IUserDao userDao;
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(IUserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public int registration(UserDto userDto) {
        User user = Converter.userDtoToUser(userDto);
        int id = 0;
        try {
            id = userDao.save(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return id;
    }

    @Override
    public void update(UserDto userDto) {
        User user = Converter.userDtoToUser(userDto);
        try {
            userDao.update(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (by.masalsky.onlineshop.exceptions.ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public User getByLogin(String login) {
        User user = null;
        try {
            user = userDao.getByLogin(login);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return user;
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        boolean isAuthorized = false;
        try {
            isAuthorized = userDao.isAuthorized(login, password);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return isAuthorized;
    }
}
