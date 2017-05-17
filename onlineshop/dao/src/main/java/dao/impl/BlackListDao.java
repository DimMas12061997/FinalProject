package dao.impl;


import dao.BaseDao;
import dao.IBlackListDao;
import entities.BlackList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlackListDao extends BaseDao<BlackList> implements IBlackListDao {

    @Autowired
    private BlackListDao(SessionFactory sessionFactory){
        super(BlackList.class, sessionFactory);
    }

}
