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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<GoodsDto>> getAllGoods() {
        List<GoodsDto> list = goodsService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createGoods(@RequestBody GoodsDto goodsDto) {
//        GoodsDto goods = goodsService.getById(goodsDto.getId());
//        if (goods == null) {
        goodsService.save(goodsDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
//        } else
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GoodsDto> getGoodsById(@PathVariable("id") Integer id) {
        GoodsDto goods = goodsService.getById(id);
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGoods(@PathVariable("id") Integer id) {
        GoodsDto category = goodsService.getById(id);
        if (category != null) {
            goodsService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
