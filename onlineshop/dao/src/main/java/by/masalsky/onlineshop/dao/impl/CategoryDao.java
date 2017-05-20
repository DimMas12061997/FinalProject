package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.dao.BaseDao;
import by.masalsky.onlineshop.dao.ICategoryDao;
import by.masalsky.onlineshop.entities.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {

    @Autowired
    private CategoryDao(SessionFactory sessionFactory){
        super(Category.class, sessionFactory);
    }

}
