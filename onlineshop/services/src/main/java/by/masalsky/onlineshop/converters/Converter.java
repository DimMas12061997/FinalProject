package by.masalsky.onlineshop.converters;


import by.masalsky.onlineshop.dto.CategoryDto;
import by.masalsky.onlineshop.dto.GoodsDto;
import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.entities.Category;
import by.masalsky.onlineshop.entities.Goods;
import by.masalsky.onlineshop.entities.OnlineShop;
import by.masalsky.onlineshop.entities.User;

public class Converter {

    public static User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRole_name(String.valueOf(user.getRole().getRole_name()));
        return userDto;
    }

    public static Category categoryDtoToCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }

    public static CategoryDto categoryToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }

    public static GoodsDto goodsToGoodsDto(Goods goods) {
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setId(goods.getId());
        goodsDto.setName(goods.getName());
        goodsDto.setNumber(goods.getNumber());
        goodsDto.setUnitPrice(goods.getUnitPrice());
        goodsDto.setDescription(goods.getDescription());
        goodsDto.setProducer(goods.getProducer());
        goodsDto.setCategory(goods.getCategoryId().getId());
        return goodsDto;
    }

    public static Goods goodsDtoToGoods(GoodsDto goodsDto) {
        Goods goods = new Goods();
        goods.setId(goodsDto.getId());
        goods.setName(goodsDto.getName());
        goods.setNumber(goodsDto.getNumber());
        goods.setUnitPrice(goodsDto.getUnitPrice());
        goods.setDescription(goodsDto.getDescription());
        goods.setProducer(goodsDto.getProducer());
        Category category = new Category();
        category.setId(goodsDto.getCategory());
        goods.setCategoryId(category);
        OnlineShop shop = new OnlineShop();
        shop.setId(1);
        goods.setShopId(shop);
        return goods;
    }
}
