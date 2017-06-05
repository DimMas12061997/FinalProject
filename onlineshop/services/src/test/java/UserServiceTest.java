//import by.masalsky.onlineshop.dto.UserDto;
//import by.masalsky.onlineshop.services.interfaces.IUserService;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@ContextConfiguration("/test-services-context.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class UserServiceTest {
//
//    @Autowired
//    private IUserService userService;
//    private UserDto expectedUser;
//    private UserDto actualUser;
//    private int userId;
//
//    @Before
//    public void buildEntity() throws Exception {
//        expectedUser = new UserDto();
//        expectedUser.setFirstName("test");
//        expectedUser.setLastName("test");
//        expectedUser.setLogin("test");
//        expectedUser.setPassword("test");
////        expectedUser.setRole_name(RoleType.ADMINISTRATOR);
////        expectedUser = BeanBuilder.buildUser("test", "test", "test", "test", new RoleDto().setRole_name(RoleType.ADMINISTRATOR)), BeanBuilder.buildShop("test", "test", 10));
//        save();
//    }
//
////    @Test
////    public void testGetByLogin() throws Exception {
////        expectedUser.setId(userId);
////        actualUser = userService.getByLogin(expectedUser.getLogin());
////        Assert.assertEquals("getByLogin() method failed: ", expectedUser, actualUser);
////        delete();
////    }
////
////    @Test
////    public void testIsAuthorized() throws Exception {
////        expectedUser.setId(userId);
////        Boolean flag = userService.isAuthorized(expectedUser.getLogin(), expectedUser.getPassword());
////        Assert.assertTrue("IsAuthorized() method failed: ", flag);
////        delete();
////    }
//
//    @Test
//    public void testSave() throws Exception {
//        expectedUser.setId(userId);
//        actualUser = userService.getById(userId);
//        Assert.assertEquals("save() method failed: ", expectedUser, actualUser);
//        delete();
//    }
//
//    @Test
//    public void testDeleteError() throws Exception {
//        expectedUser.setId(999);
//        delete();
//        actualUser = userService.getById(userId);
//        Assert.assertNotEquals("delete() method failed: ", actualUser);
//    }
//
////    @Test
////    public void testGetAll() throws Exception {
////        expectedUser.setId(userId);
////        List<UserDto> listUserActual = userService.getAll();
////        List<UserDto> listUserExpected = new ArrayList<UserDto>();
////        listUserExpected.add(expectedUser);
////        Assert.assertFalse("getAll() method failed", listUserActual.contains(listUserExpected));
////        delete();
////    }
//
//    @Test
//    public void testGetById() throws Exception {
//        expectedUser.setId(userId);
//        actualUser = userService.getById(userId);
//        Assert.assertEquals("getById() method failed: ", expectedUser, actualUser);
//        delete();
//    }
//
//
//    @Test
//    public void testUpdate() throws Exception {
//        expectedUser.setId(userId);
//        expectedUser.setLogin("update");
//        userService.update(expectedUser);
//        actualUser = userService.getById(userId);
//        Assert.assertEquals("update() method failed: ", expectedUser, actualUser);
//        delete();
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        delete();
//        actualUser = userService.getById(userId);
//        Assert.assertNull("delete() method failed: ", actualUser);
//    }
//
//    @After
//    public void commitReset() throws Exception {
//        expectedUser = null;
//        actualUser = null;
//        userId = 0;
//    }
//
//    private void save() throws Exception {
//        userId = userService.save(expectedUser);
//    }
//
//    private void delete() throws Exception {
//        userService.delete(userId);
//    }
//
//}