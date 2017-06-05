package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.OrderDto;
import by.masalsky.onlineshop.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> list = orderService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto) {
        int flag = orderService.save(orderDto);
        if (flag == -1)
            return new ResponseEntity<>("The goods in such quantity are not present", HttpStatus.BAD_REQUEST);
        else if (flag == -2)
            return new ResponseEntity<>("User is in the black list", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Integer id) {
        OrderDto order = orderService.getById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrder(@PathVariable("id") Integer id) {
        OrderDto order = orderService.getById(id);
        if (order != null) {
            orderService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>("There is no such order", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateCategory(@PathVariable("id") Integer id, @RequestBody OrderDto orderDto) {
        orderDto.setId(id);
        orderService.update(orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public ResponseEntity makePurchase() {
        String info = orderService.makePurchase();
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
