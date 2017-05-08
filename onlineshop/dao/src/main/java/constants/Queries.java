package constants;


public class Queries {
    public static String GET_BY_LOGIN = "from User where login = :login";
    public static String CHECK_AUTHORIZATION = "from User where login = :login and password = :password";
}
