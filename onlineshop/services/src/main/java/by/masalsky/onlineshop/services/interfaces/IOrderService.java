package by.masalsky.onlineshop.services.interfaces;


import by.masalsky.onlineshop.dto.OrderDto;

public interface IOrderService extends IService<OrderDto> {
    String makePurchase();
    OrderDto getByUserId(int id);
}

