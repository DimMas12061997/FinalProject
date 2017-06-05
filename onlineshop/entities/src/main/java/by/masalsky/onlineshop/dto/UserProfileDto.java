package by.masalsky.onlineshop.dto;

public class UserProfileDto extends BeanDto {
    private String email;
    private String address;
    private double budget;
    private String creditCard;
    private int userId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getUser() {
        return userId;
    }

    public void setUser(int user) {
        this.userId = user;
    }

    @Override
    public String toString() {
        return "UserProfileDto{" +
                "email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", budget=" + budget +
                ", creditCard='" + creditCard + '\'' +
                ", userId=" + userId +
                '}';
    }
}
