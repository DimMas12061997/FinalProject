package by.masalsky.onlineshop.dto;

public class UserDto extends BeanDto {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private RoleDto role;
    private OnlineShopDto shop;
    private String createdDate;

    public UserDto() {
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public OnlineShopDto getShop() {
        return shop;
    }

    public void setShop(OnlineShopDto shop) {
        this.shop = shop;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
