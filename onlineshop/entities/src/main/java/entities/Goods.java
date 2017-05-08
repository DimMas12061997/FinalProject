package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = ("goods"))
public class Goods extends Bean {
    private String name;
    private int number;
    private double unitPrice;
    private String producer;
    private String description;
    private String createdDate;
    private OnlineShop shopId;
    private Category categoryId;
    private Set<Order> orderList;

    @Override
    public String toString() {
        return "Goods{" +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", shopId=" + shopId +
                ", categoryId=" + categoryId +
                '}';
    }

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = ("created_date"))
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "shop_id")
    public OnlineShop getShopId() {
        return shopId;
    }

    public void setShopId(OnlineShop shopId) {
        this.shopId = shopId;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "category_id")
    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Column(nullable = false, name = ("producer"))
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Column(nullable = false, name = ("description"))
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false, name = ("goods_name"))
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false, name = ("number_goods"))
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Column(nullable = false, precision = 2, name = ("unit_price"))
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @ManyToMany(mappedBy = "goodsList")
    public Set<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orderList = orderList;
    }

}
