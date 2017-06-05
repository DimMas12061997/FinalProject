package by.masalsky.onlineshop.dao.impl;

import by.masalsky.onlineshop.constants.DaoConstants;
import by.masalsky.onlineshop.constants.Queries;
import by.masalsky.onlineshop.dao.interfaces.IUserProfileDao;
import by.masalsky.onlineshop.entities.UserProfile;
import by.masalsky.onlineshop.exceptions.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDao extends BaseDao<UserProfile> implements IUserProfileDao {
    private final static Logger logger = LoggerFactory.getLogger(UserProfileDao.class);
    @Autowired
    private UserProfileDao(SessionFactory sessionFactory){
        super(UserProfile.class, sessionFactory);
    }

    @Override
    public UserProfile getByUserId(int id) {
        UserProfile user = null;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.GET_BY_USER_ID);
            query.setParameter("id", id);
            user = (UserProfile) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return user;
    }
}
