package by.masalsky.onlineshop.converters;


import by.masalsky.onlineshop.dto.*;
import by.masalsky.onlineshop.entities.*;
import by.masalsky.onlineshop.enums.PaymentType;

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

    public static UserProfile userProfileDtoToUserProfile(UserProfileDto userDto) {
        UserProfile user = new UserProfile();
        user.setId(userDto.getId());
        user.setBudget(userDto.getBudget());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setCreditCard(userDto.getCreditCard());
        return user;
    }

    public static UserProfileDto userProfileToUserProfileDto(UserProfile user) {
        UserProfileDto userDto = new UserProfileDto();
        userDto.setId(user.getId());
        userDto.setBudget(user.getBudget());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setCreditCard(user.getCreditCard());
        userDto.setUser(user.getUser().getId());
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

    public static Order orderDtoToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setStatus(PaymentType.OPEN);
        order.setNumber(orderDto.getNumber());
        User user = new User();
        user.setId(orderDto.getUserId());
        order.setUser(user);
        return order;
    }

    public static OrderDto orderToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setNumber(order.getNumber());
        orderDto.setOrderCost(order.getOrderCost());
        orderDto.setStatus(order.getStatus());
        orderDto.setUserId(order.getUser().getId());
        return orderDto;
    }

    public static BlackList blackListDtoToBlackList(BlackListDto blackListDto){
        BlackList blackList = new BlackList();
        blackList.setId(blackListDto.getId());
        User user = new User();
        user.setId(blackListDto.getUser());
        blackList.setUser(user);
        return blackList;
    }

    public static BlackListDto blackListToBlackListDto(BlackList blackList){
        BlackListDto blackListDto = new BlackListDto();
        blackListDto.setId(blackList.getId());
        blackListDto.setUser(blackList.getUser().getId());
        return blackListDto;
    }

    public static OnlineShopDto shopToShopDto(OnlineShop shop){
        OnlineShopDto shopDto = new OnlineShopDto();
        shopDto.setId(shop.getId());
        shopDto.setName(shop.getName());
        shopDto.setDescription(shop.getDescription());
        shopDto.setProfit(shop.getProfit());
        return shopDto;
    }
}
