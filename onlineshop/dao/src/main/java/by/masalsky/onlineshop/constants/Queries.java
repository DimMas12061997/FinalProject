package by.masalsky.onlineshop.constants;


public class Queries {
    public static String GET_BY_LOGIN = "from User where login = :login";
    public static String GET_BY_USER_ID = "from UserProfile where user.id = :id";
    public static String GET_BY_USER_ID_FROM_ORDER = "from Order where user.id = :id";
    public static String GET_BY_USER_ID_FROM_BLACKLIST = "from BlackList where user.id = :id";
    public static String GET_BY_CATEGORY_NAME = "from Category where categoryName = :name";
    public static String CHECK_AUTHORIZATION = "from User where login = :login and password = :password";
}
