package by.masalsky.onlineshop.dao.interfaces;


import by.masalsky.onlineshop.entities.BlackList;

public interface IBlackListDao extends IBaseDao<BlackList> {
    BlackList getByUserId(int id);
}

