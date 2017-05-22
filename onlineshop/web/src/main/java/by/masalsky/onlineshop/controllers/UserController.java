package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.services.IUserService;
import by.masalsky.onlineshop.util.BeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAll();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getArticleById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        User user = userService.getById(userDto.getId());
        if (user == null) {
            user = BeanBuilder.buildUser(userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getPassword(), BeanBuilder.buildRole(userDto.getRole().getRole_name()), BeanBuilder.buildShop(userDto.getShop().getName(), userDto.getShop().getDescription(), userDto.getShop().getProfit()));
            userService.save(user);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody UserDto userDto) {
        User user = BeanBuilder.buildUser(userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getPassword(), BeanBuilder.buildRole(userDto.getRole().getRole_name()), BeanBuilder.buildShop(userDto.getShop().getName(), userDto.getShop().getDescription(), userDto.getShop().getProfit()));
        userService.update(user);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
}
