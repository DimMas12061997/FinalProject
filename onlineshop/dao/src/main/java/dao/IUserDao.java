package dao;


import entities.User;

public interface IUserDao extends IBaseDao<User> {
    User getByLogin(String login);
    boolean isAuthorized(String login, String password);
}

