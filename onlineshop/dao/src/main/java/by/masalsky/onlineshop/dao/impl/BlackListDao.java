package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.dao.interfaces.IBlackListDao;
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

}
