package dao.impl;


import dao.BaseDao;
import dao.IRoleDao;
import entities.Role;

public class RoleDao extends BaseDao<Role> implements IRoleDao {

    public RoleDao(Class<Role> persistentClass) {
        super(persistentClass);
    }

}
