package by.masalsky.onlineshop.services.impl;


import by.masalsky.onlineshop.dao.IRoleDao;
import by.masalsky.onlineshop.dao.impl.RoleDao;
import by.masalsky.onlineshop.entities.Role;
import by.masalsky.onlineshop.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import by.masalsky.onlineshop.services.AbstractService;

import java.util.List;

public class RoleService extends AbstractService<Role> implements IRoleService {

    private IRoleDao roleDao;

    @Autowired
    public RoleService(RoleDao roleDao) {
        super(roleDao);
        this.roleDao = roleDao;
    }


    public int save(Role entity) {
        return 0;
    }

    public List<Role> getAll() {
        return null;
    }

    public Role getById(int id) {
        return null;
    }

    public void update(Role entity) {

    }

    public void delete(int id) {

    }
}
