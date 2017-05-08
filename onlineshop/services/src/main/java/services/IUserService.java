package services;


import entities.User;

public interface IUserService extends IService<User> {
    User getByLogin(String login);
    boolean isAuthorized(String login, String password);
}

