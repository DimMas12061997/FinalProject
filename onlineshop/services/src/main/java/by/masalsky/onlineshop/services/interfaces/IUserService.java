package by.masalsky.onlineshop.services.interfaces;


import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.entities.User;

public interface IUserService extends IService<User> {
    int registration(UserDto userDto);

    void update(UserDto userDto);

    User getByLogin(String login);
    boolean isAuthorized(String login, String password);
}

