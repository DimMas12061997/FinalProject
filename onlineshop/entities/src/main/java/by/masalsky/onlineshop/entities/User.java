package by.masalsky.onlineshop.entities;

import javax.persistence.*;

@Entity
@Table(name = ("user"))
public class User extends Bean {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Role role;
    private OnlineShop shop;
    private String createdDate;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", shop=" + shop +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false, name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false, name = "shop_id")
    public OnlineShop getShop() {
        return shop;
    }

    public void setShop(OnlineShop shop) {
        this.shop = shop;
    }

    @Column(nullable = false, name = ("first_name"))
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false, name = ("last_name"))
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false, unique = true, name = ("login"))
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(nullable = false, name = ("password"))
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        @Column(name = ("created_date"))
//    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = ("created_date"))
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (shop != null ? !shop.equals(user.shop) : user.shop != null) return false;
        return createdDate != null ? createdDate.equals(user.createdDate) : user.createdDate == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
