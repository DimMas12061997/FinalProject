import dao.impl.UserDao;
import entities.User;
import enums.RoleType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import util.BeanBuilder;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-dao-context.xml")
@Transactional(transactionManager = "transactionManager")
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;
    private User expectedUser;
    private User actualUser;
    private int userId;

    @Before
    public void buildEntity() throws Exception {
        expectedUser = BeanBuilder.buildUser("дмитрий", "масальский", "dimas", "12061997", BeanBuilder.buildRole(RoleType.ADMINISTRATOR), BeanBuilder.buildShop("xx","qwe", 2000));
        save();
    }

    @Test
    public void testGetByLogin() throws Exception {
        expectedUser.setId(userId);
        actualUser = userDao.getByLogin(expectedUser.getLogin());
        Assert.assertEquals("getByLogin() method failed: ", expectedUser, actualUser);
        delete();
    }

    @Test
    public void testIsAuthorized() throws Exception {
        expectedUser.setId(userId);
        Boolean flag = userDao.isAuthorized(expectedUser.getLogin(), expectedUser.getPassword());
        System.out.println(flag);
        Assert.assertTrue("IsAuthorized() method failed: ", flag);
        delete();
    }

    @Test
    public void testSave() throws Exception {
        actualUser = userDao.getById(userId);
        Assert.assertEquals("save() method failed: ", expectedUser, actualUser);
        expectedUser.setId( userId);
        delete();
    }

    @Test
    public void testGetAll() throws Exception {
        expectedUser.setId(userId);
        List<User> listUserActual = userDao.getAll();
        List<User> listUserExpected = new ArrayList<User>();
        listUserExpected.add(expectedUser);
        Assert.assertFalse("getAll() method failed", listUserActual.contains(listUserExpected));
        delete();
    }

    @Test
    public void testGetById() throws Exception {
        expectedUser.setId(userId);
        actualUser = userDao.getById(userId);
        Assert.assertEquals("getById() method failed: ", expectedUser, actualUser);
        delete();
    }


    @Test
    public void testUpdate() throws Exception {
        expectedUser.setId(userId);
        expectedUser.setLogin("update");
        userDao.update(expectedUser);
        actualUser = userDao.getById(userId);
        Assert.assertEquals("update() method failed: ", expectedUser, actualUser);
        delete();
    }

    @Test
    public void testDelete() throws Exception {
        delete();
        actualUser = userDao.getById(userId);
        Assert.assertNull("delete() method failed: ", actualUser);
    }

    @After
    public void commitReset() throws Exception{
        expectedUser = null;
        actualUser = null;
        userId = 0;
    }

    private void save() throws Exception {
        userId = userDao.save(expectedUser);
    }

    private void delete() throws Exception {
        userDao.delete(userId);
    }

}