package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.converters.Converter;
import by.masalsky.onlineshop.dao.interfaces.IUserDao;
import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.entities.OnlineShop;
import by.masalsky.onlineshop.entities.Role;
import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.services.interfaces.IUserService;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public int save(UserDto userDto) {
        User user = Converter.userDtoToUser(userDto);
        user = setUserRoleAndShop(user);
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
    public List<UserDto> getAll() {
        List<User> users = null;
        UserDto userDto = null;
        List<UserDto> usersDto = new ArrayList<UserDto>();
        try {
            users = userDao.getAll();
            for (User user : users) {
                userDto = Converter.userToUserDto(user);
                usersDto.add(userDto);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return usersDto;
    }

    @Override
    public UserDto getById(int id) {
        User user = null;
        UserDto userDto = null;
        try {
            user = userDao.getById(id);
            if (user != null)
                userDto = Converter.userToUserDto(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return userDto;
    }

    @Override
    public User setUserRoleAndShop(User user){
        Role role = new Role();
        role.setId(2);
        user.setRole(role);
        OnlineShop shop = new OnlineShop();
        shop.setId(1);
        user.setShop(shop);
        return user;
    }

    @Override
    public void update(UserDto userDto) {
        User user = Converter.userDtoToUser(userDto);
        User userTmp = userDao.getById(userDto.getId());
        user.setShop(userTmp.getShop());
        user.setRole(userTmp.getRole());
        try {
            userDao.update(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserDto getByLogin(String login) {
        User user = null;
        UserDto userDto = null;
        try {
            user = userDao.getByLogin(login);
            if (user != null)
                userDto = Converter.userToUserDto(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return userDto;
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
