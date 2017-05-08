package entities;

import javax.persistence.*;

@Entity
@Table(name = ("user_profil"))
public class UserProfile extends Bean {
    private String email;
    private String address;
    private double budget;
    private String creditCard;
    private User user;

    @Column(unique = true, nullable = false, name = ("email"))
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false, name = ("address"))
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(nullable = false, name = ("budget"), precision = 2)
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Column(nullable = false, name = ("credit_card_number"))
    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", budget=" + budget +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
