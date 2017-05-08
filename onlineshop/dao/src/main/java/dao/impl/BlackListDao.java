package dao.impl;


import dao.BaseDao;
import dao.IBlackListDao;
import entities.BlackList;

public class BlackListDao extends BaseDao<BlackList> implements IBlackListDao {

    public BlackListDao(Class<BlackList> persistentClass) {
        super(persistentClass);
    }

}
