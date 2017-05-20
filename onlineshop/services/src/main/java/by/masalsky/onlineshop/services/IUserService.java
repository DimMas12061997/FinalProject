package by.masalsky.onlineshop.services;


import by.masalsky.onlineshop.entities.User;

public interface IUserService extends IService<User> {
    User getByLogin(String login);
    boolean isAuthorized(String login, String password);
}

