package by.masalsky.onlineshop.dao.impl;


import by.masalsky.onlineshop.dao.BaseDao;
import by.masalsky.onlineshop.dao.IRoleDao;
import by.masalsky.onlineshop.entities.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends BaseDao<Role> implements IRoleDao {

    @Autowired
    private RoleDao(SessionFactory sessionFactory){
        super(Role.class, sessionFactory);
    }

}
