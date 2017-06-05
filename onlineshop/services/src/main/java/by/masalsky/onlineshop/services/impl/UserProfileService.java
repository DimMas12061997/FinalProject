package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.converters.Converter;
import by.masalsky.onlineshop.dao.interfaces.IUserDao;
import by.masalsky.onlineshop.dao.interfaces.IUserProfileDao;
import by.masalsky.onlineshop.dto.UserProfileDto;
import by.masalsky.onlineshop.entities.UserProfile;
import by.masalsky.onlineshop.exceptions.ServiceException;
import by.masalsky.onlineshop.services.interfaces.IUserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserProfileService implements IUserProfileService {
    @Autowired
    private IUserProfileDao userProfileDao;
    @Autowired
    private IUserDao userDao;
    private final static Logger logger = LoggerFactory.getLogger(UserProfile.class);

    @Override
    public int save(UserProfileDto userDto) {
        int id = 0, flag = 0;
        UserProfile user = Converter.userProfileDtoToUserProfile(userDto);
        try {
            user.setUser(userDao.getById(userDto.getUser()));
            for (UserProfile userProfile : userProfileDao.getAll())
                if (userProfile.getUser().getId() == userDto.getUser())
                    flag++;
            if (flag == 0)
                id = userProfileDao.save(user);
            else
                id = -1;
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return id;
    }

    @Override
    public List<UserProfileDto> getAll() {
        List<UserProfile> users = null;
        UserProfileDto userDto = null;
        List<UserProfileDto> usersDto = new ArrayList<UserProfileDto>();
        try {
            users = userProfileDao.getAll();
            for (UserProfile user : users) {
                userDto = Converter.userProfileToUserProfileDto(user);
                usersDto.add(userDto);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return usersDto;
    }

    @Override
    public UserProfileDto getById(int id) {
        UserProfile user = null;
        UserProfileDto userDto = null;
        try {
            user = userProfileDao.getById(id);
            if (user != null)
                userDto = Converter.userProfileToUserProfileDto(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return userDto;
    }

    @Override
    public void update(UserProfileDto userDto) {
        UserProfile user = Converter.userProfileDtoToUserProfile(userDto);
        user.setUser(userDao.getById(userDto.getUser()));
        try {
            userProfileDao.update(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            userProfileDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public UserProfileDto getByUserId(int id) {
        UserProfile user = null;
        UserProfileDto userDto = null;
        try {
            user = userProfileDao.getByUserId(id);
            if (user != null)
                userDto = Converter.userProfileToUserProfileDto(user);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return userDto;
    }
}
