package by.masalsky.onlineshop.dto;

import by.masalsky.onlineshop.enums.PaymentType;


public class OrderDto extends BeanDto {
    private double orderCost;
    private int number;
    private PaymentType status;
    private int userId;
    private int goodsId;

    public OrderDto() {
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public PaymentType getStatus() {
        return status;
    }

    public void setStatus(PaymentType status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderCost=" + orderCost +
                ", number=" + number +
                ", status=" + status +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                '}';
    }
}
