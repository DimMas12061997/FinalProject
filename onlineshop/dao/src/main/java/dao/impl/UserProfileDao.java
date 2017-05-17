package dao.impl;

import dao.BaseDao;
import dao.IUserProfileDao;
import entities.UserProfile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDao extends BaseDao<UserProfile> implements IUserProfileDao {
    @Autowired
    private UserProfileDao(SessionFactory sessionFactory){
        super(UserProfile.class, sessionFactory);
    }

}
