import dao.impl.UserDao;
import entities.User;
import enums.RoleType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.*;
import util.BeanBuilder;
import utils.HibernateUtil;

import java.io.Serializable;

public class UserServiceTest {
    private static UserDao userDao;
    private static HibernateUtil util;
    private static Session session;
    private User expectedUser;
    private User actualUser;
    private Serializable userId;
    private Transaction transaction;

    @BeforeClass
    public static void initTest(){
        userDao = new UserDao(User.class);
        util = HibernateUtil.getInstance();
        session = util.getSession();
    }

    @Before
    public void buildEntity() throws Exception {
        expectedUser = BeanBuilder.buildUser("дмитрий", "масальский", "dimas", "12061997", BeanBuilder.buildRole(RoleType.USER), BeanBuilder.buildShop("xx","qwe", 2000));
        transaction = session.beginTransaction();
    }

    @Test
    public void testGetByLogin() throws Exception {
        save();
        expectedUser.setId((Integer) userId);
        actualUser = userDao.getByLogin(expectedUser.getLogin());
        Assert.assertEquals("getByLogin() method failed: ", expectedUser, actualUser);
        delete();
    }

    @Test
    public void testIsAuthorized() throws Exception {
        save();
        expectedUser.setId((Integer) userId);
        Boolean flag = userDao.isAuthorized(expectedUser.getLogin(), expectedUser.getPassword());
        System.out.println(flag);
        Assert.assertTrue("IsAuthorized() method failed: ", flag);
        delete();
    }

    @Test
    public void testSave() throws Exception {
        save();
        actualUser = userDao.getById((Integer) userId);
        Assert.assertEquals("save() method failed: ", expectedUser, actualUser);
        expectedUser.setId((Integer) userId);
        delete();
    }

    @Test
    public void testGetAll() throws Exception {
        for(User user : userDao.getAll())
            System.out.println(user);
    }

    @Test
    public void testGetById() throws Exception {
        save();
        expectedUser.setId((Integer) userId);
        actualUser = userDao.getById((Integer) userId);
        Assert.assertEquals("getById() method failed: ", expectedUser, actualUser);
        delete();
    }


    @Test
    public void testUpdate() throws Exception {
        save();
        expectedUser.setId((Integer) userId);
        expectedUser.setLogin("update");
        userDao.update(expectedUser);
        actualUser = userDao.getById((Integer) userId);
        Assert.assertEquals("update() method failed: ", expectedUser, actualUser);
        delete();
    }

    @Test
    public void testDelete() throws Exception {
        save();
        delete();
        actualUser = userDao.getById((Integer) userId);
        Assert.assertNull("delete() method failed: ", actualUser);
    }

    @After
    public void commitReset() throws Exception{
        transaction.commit();
        expectedUser = null;
        actualUser = null;
        userId = null;
        transaction = null;
    }

    private void save() throws Exception {
        userId = userDao.save(expectedUser);
    }

    private void delete() throws Exception {
        userDao.delete((Integer) userId);
    }

}