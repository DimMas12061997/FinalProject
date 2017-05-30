package by.masalsky.onlineshop.dao.interfaces;


import by.masalsky.onlineshop.entities.Goods;

import java.util.List;

public interface IGoodsDao extends IBaseDao<Goods> {
    List<Goods> findAllSortByPrice();

}

