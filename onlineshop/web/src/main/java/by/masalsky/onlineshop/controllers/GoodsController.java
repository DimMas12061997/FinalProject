package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.GoodsDto;
import by.masalsky.onlineshop.services.interfaces.IGoodsService;
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
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<GoodsDto>> getAllGoods() {
        List<GoodsDto> list = goodsService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createGoods(@RequestBody GoodsDto goodsDto) {
        goodsService.save(goodsDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GoodsDto> getGoodsById(@PathVariable("id") Integer id) {
        GoodsDto goods = goodsService.getById(id);
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteGoods(@PathVariable("id") Integer id) {
        GoodsDto goods = goodsService.getById(id);
        if (goods != null) {
            goodsService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>("This product does not exist", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateGoods(@PathVariable("id") Integer id, @RequestBody GoodsDto goodsDto) {
        goodsDto.setId(id);
        goodsService.update(goodsDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
