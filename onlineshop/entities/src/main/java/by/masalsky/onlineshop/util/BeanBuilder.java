package by.masalsky.onlineshop.util;

import by.masalsky.onlineshop.entities.BlackList;
import by.masalsky.onlineshop.entities.OnlineShop;
import by.masalsky.onlineshop.entities.Role;
import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.enums.RoleType;

public class BeanBuilder {
    private BeanBuilder() {
    }

    public static User buildUser(String firstName, String lastName, String login, String password, Role role, OnlineShop shop) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        user.setShop(shop);
        return user;
    }

    public static Role buildRole(RoleType name){
        Role role = new Role();
        role.setRole_name(name);
        return role;
    }

    public static OnlineShop buildShop(String name, String description, double profit) {
        OnlineShop shop = new OnlineShop();
        shop.setName(name);
        shop.setDescription(description);
        shop.setProfit(profit);
        return shop;
    }

    public static BlackList buildBlackList(User user) {
        BlackList blackList = new BlackList();
        blackList.setUser(user);
        return blackList;
    }
}
