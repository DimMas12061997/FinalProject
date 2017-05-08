package entities;

import enums.PaymentType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = ("orders"))
public class Order extends Bean {
    private double orderCost;
    private String createdDate;
    private PaymentType status;
    private User user;
    private Set<Goods> goodsList;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                ", orderCost=" + orderCost +
                ", createdDate='" + createdDate + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }

    @Column(nullable = false, precision = 2, name = ("order_cost"))
    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = ("created_date"))
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('OPEN', 'CLOSED')")
    public PaymentType getStatus() {
        return status;
    }

    public void setStatus(PaymentType status) {
        this.status = status;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "order_goods",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_goods"))
    public Set<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(Set<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
