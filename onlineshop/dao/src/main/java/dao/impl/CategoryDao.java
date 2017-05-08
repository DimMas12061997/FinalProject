package dao.impl;


import dao.BaseDao;
import dao.ICategoryDao;
import entities.Category;

public class CategoryDao extends BaseDao<Category> implements ICategoryDao {

    public CategoryDao(Class<Category> persistentClass) {
        super(persistentClass);
    }

}
