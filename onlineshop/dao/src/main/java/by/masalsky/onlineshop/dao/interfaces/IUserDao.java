package by.masalsky.onlineshop.dao.interfaces;


import by.masalsky.onlineshop.entities.User;

public interface IUserDao extends IBaseDao<User> {
    User getByLogin(String login);
    boolean isAuthorized(String login, String password);
}

