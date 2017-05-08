package dao.impl;

import dao.BaseDao;
import dao.IUserProfileDao;
import entities.UserProfile;

public class UserProfileDao extends BaseDao<UserProfile> implements IUserProfileDao {
    public UserProfileDao(Class<UserProfile> persistentClass) {
        super(persistentClass);
    }
}
