package by.masalsky.onlineshop.services.interfaces;


import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.entities.User;

public interface IUserService extends IService<UserDto> {
    UserDto getByLogin(String login);
    boolean isAuthorized(String login, String password);
    User setUserRoleAndShop(User userDto);
}

