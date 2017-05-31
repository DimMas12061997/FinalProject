package by.masalsky.onlineshop.dao.interfaces;


import by.masalsky.onlineshop.entities.Category;

public interface ICategoryDao extends IBaseDao<Category> {
    Category getByName(String name);
}

