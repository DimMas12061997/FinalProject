package services.impl;


import dao.IRoleDao;
import dao.impl.RoleDao;
import entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import services.AbstractService;
import services.IRoleService;

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
