package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.dao.BaseDao;
import by.masalsky.onlineshop.dao.IBlackListDao;
import by.masalsky.onlineshop.entities.BlackList;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlackListDao extends BaseDao<BlackList> implements IBlackListDao {
    private static Logger logger = LoggerFactory.getLogger(BlackListDao.class);

    @Autowired
    private BlackListDao(SessionFactory sessionFactory){
        super(BlackList.class, sessionFactory);
    }

//    @Override
//    public void removeByUserId(int id) {
//        try {
//            Session session = getCurrentSession();
//            Query query = session.createQuery(DaoConstants.HQL_DELETE_BY_USER_ID);
//            query.setParameter(DaoConstants.PARAMETER_USER_ID, id);
//            query.executeUpdate();
//        }
//        catch(HibernateException e){
//            logger.error(DaoConstants.ERROR_DAO + e);
//            throw new DaoException(DaoConstants.ERROR_DAO + e);
//        }
//    }
}
