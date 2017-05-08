import dao.impl.ShopDao;
import dao.impl.UserDao;
import entities.OnlineShop;
import entities.User;
import util.BeanBuilder;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        ShopDao shopDao = new ShopDao(OnlineShop.class);
        List<OnlineShop> results = shopDao.getAll();
        results.forEach(onlineShop -> System.out.println(onlineShop.getName() + " " + onlineShop.getDescription()));
        System.out.println(shopDao.getById(13));
        OnlineShop shop = BeanBuilder.buildShop("ProSport","best shop", 20000);
//        shopDao.save(shop);
        UserDao userDao = new UserDao(User.class);
//        userDao.save(BeanBuilder.buildUser("дмитрий", "масальский", "dimas", "12061997", BeanBuilder.buildRole("ADMINISTRATOR"), BeanBuilder.buildShop("xx","qwe", 2000)));
        System.out.println(userDao.getByLogin("dimas"));
//        shopDao.delete(2);
    }
}
