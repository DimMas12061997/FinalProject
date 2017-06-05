package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.OnlineShopDto;
import by.masalsky.onlineshop.services.interfaces.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    IShopService shopService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OnlineShopDto>> getInfoAboutShop() {
        List<OnlineShopDto> list = shopService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
