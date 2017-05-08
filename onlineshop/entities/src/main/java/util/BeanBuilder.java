package util;

import entities.OnlineShop;
import entities.Role;
import entities.User;
import enums.RoleType;

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
}
