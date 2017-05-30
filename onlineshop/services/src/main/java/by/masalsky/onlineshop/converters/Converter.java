package by.masalsky.onlineshop.converters;


import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.entities.OnlineShop;
import by.masalsky.onlineshop.entities.Role;
import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.enums.RoleType;

public class Converter {

    public static User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        Role role = new Role();
        role.setId(2);
        role.setRole_name(RoleType.CLIENT);
        user.setRole(role);
        OnlineShop shop = new OnlineShop();
        shop.setId(1);
        shop.setDescription("shop");
        shop.setName("sportix");
        shop.setProfit(0);
        user.setShop(shop);
//        user.setCreatedDate(userDto.getCreatedDate());
        return user;
    }
}
