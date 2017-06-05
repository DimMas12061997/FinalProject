package by.masalsky.onlineshop.entities;

import by.masalsky.onlineshop.enums.PaymentType;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = ("orders"))
public class Order extends Bean {
    private double orderCost;
    private int number;
    private PaymentType status;
    private User user;
    private Set<Goods> goodsList;

    public Order() {
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderCost=" + orderCost +
                ", number=" + number +
                ", status=" + status +
                ", user=" + user +
                ", goodsList=" + goodsList +
                '}';
    }

    @Column(nullable = false, precision = 2, name = ("order_cost"))
    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('OPEN', 'CLOSED')")
    public PaymentType getStatus() {
        return status;
    }

    public void setStatus(PaymentType status) {
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_goods",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_goods"))
    public Set<Goods> getGoodsList() {
        return goodsList;
    }

    @Column(nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setGoodsList(Set<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
