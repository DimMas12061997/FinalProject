//import by.masalsky.onlineshop.dao.impl.BlackListDao;
//import by.masalsky.onlineshop.entities.BlackList;
//import by.masalsky.onlineshop.entities.User;
//import by.masalsky.onlineshop.enums.RoleType;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//import by.masalsky.onlineshop.util.BeanBuilder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:test-dao-context.xml")
//@Transactional(transactionManager = "transactionManager")
//public class BlackListDaoTest {
//    @Autowired
//    private BlackListDao blackListDao;
//    private BlackList expectedBlackList;
//    private BlackList actualBlackList;
//    private int blackListId;
//
////    @Test
////    public void testDeleteByUserId() throws Exception {
////        blackListDao.removeByUserId(blackListId);
////        actualBlackList = blackListDao.getById(blackListId);
////        Assert.assertNull("deleteByUserId() method failed: ", actualBlackList);
////    }
//
//    @Before
//    public void buildEntity() throws Exception {
//        User user = BeanBuilder.buildUser("дмитрий", "масальский", "dimas", "12061997", BeanBuilder.buildRole(RoleType.ADMINISTRATOR), BeanBuilder.buildShop("xx","qwe", 2000));
//        expectedBlackList = BeanBuilder.buildBlackList(user);
//        save();
//    }
//
//    @Test
//    public void testSave() throws Exception {
//        actualBlackList = blackListDao.getById(blackListId);
//        Assert.assertEquals("save() method failed: ", expectedBlackList, actualBlackList);
//        expectedBlackList.setId(blackListId);
//        delete();
//    }
//
//
//    @Test
//    public void testGetAll() throws Exception {
//        expectedBlackList.setId(blackListId);
//        List<BlackList> listUserActual = blackListDao.getAll();
//        List<BlackList> listUserExpected = new ArrayList<BlackList>();
//        listUserExpected.add(expectedBlackList);
//        Assert.assertFalse("getAll() method failed", listUserActual.contains(listUserExpected));
//        delete();
//    }
//
//    @Test
//    public void testGetById() throws Exception {
//        expectedBlackList.setId(blackListId);
//        actualBlackList = blackListDao.getById(blackListId);
//        Assert.assertEquals("getById() method failed: ", expectedBlackList, actualBlackList);
//        delete();
//    }
//
//
//    @Test
//    public void testUpdate() throws Exception {
//        expectedBlackList.setId(blackListId);
//        expectedBlackList.setId(555);
//        blackListDao.update(expectedBlackList);
//        actualBlackList = blackListDao.getById(blackListId);
//        Assert.assertEquals("update() method failed: ", expectedBlackList, actualBlackList);
//        delete();
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        delete();
//        actualBlackList = blackListDao.getById(blackListId);
//        Assert.assertNull("delete() method failed: ", actualBlackList);
//    }
//
//    @After
//    public void commitReset() throws Exception{
//        expectedBlackList = null;
//        actualBlackList = null;
//        blackListId = 0;
//    }
//
//    private void save() throws Exception {
//        blackListId = blackListDao.save(expectedBlackList);
//    }
//
//    private void delete() throws Exception {
//        blackListDao.delete(blackListId);
//    }
//
//
//}
