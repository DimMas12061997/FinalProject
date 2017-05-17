package dao.impl;


import dao.BaseDao;
import dao.ICategoryDao;
import entities.Category;
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
