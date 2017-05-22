package by.masalsky.onlineshop.dto;

import by.masalsky.onlineshop.enums.PaymentType;


public class OrderDto extends BeanDto {
    private double orderCost;
    private String createdDate;
    private PaymentType status;
    private UserDto user;

    public OrderDto() {
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public PaymentType getStatus() {
        return status;
    }

    public void setStatus(PaymentType status) {
        this.status = status;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

}
