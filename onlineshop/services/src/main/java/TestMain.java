import entities.User;
import enums.RoleType;
import services.impl.UserService;
import util.BeanBuilder;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println("Поиск по ID" + userService.getById(1));
       List<User> results = userService.getAll();
        System.out.println("Все юзеры");
        for (User temp : results)
            System.out.println(temp);
        userService.save(BeanBuilder.buildUser("qwe", "q", "dimas", "12061997", BeanBuilder.buildRole(RoleType.USER), BeanBuilder.buildShop("2", "qwe", 2000)));

//        userService.delete(3);
//        user.setLogin("qwe");
//        userService.update(user);
    }
}
