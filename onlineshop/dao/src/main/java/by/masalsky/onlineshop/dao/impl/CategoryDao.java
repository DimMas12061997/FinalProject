package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.constants.DaoConstants;
import by.masalsky.onlineshop.constants.Queries;
import by.masalsky.onlineshop.dao.interfaces.ICategoryDao;
import by.masalsky.onlineshop.entities.Category;
import by.masalsky.onlineshop.exceptions.DaoException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends BaseDao<Category> implements ICategoryDao {
    private final static Logger logger = LoggerFactory.getLogger(CategoryDao.class);

    @Autowired
    private CategoryDao(SessionFactory sessionFactory){
        super(Category.class, sessionFactory);
    }

    @Override
    public Category getByName(String name) {
        Category category = null;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery(Queries.GET_BY_CATEGORY_NAME);
            query.setParameter("name", name);
            category = (Category) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(DaoConstants.ERROR_DAO + e);
            throw new DaoException(DaoConstants.ERROR_DAO + e);
        }
        return category;
    }
}
