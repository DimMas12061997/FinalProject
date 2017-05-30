package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.services.interfaces.IUserService;
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
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/q")
    public String home(){
        return "Hello dimaQ!";
    }

    @RequestMapping(value = "/qw")
    public String homeW(){
        return "Hello dimaW!";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAll();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getArticleById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        User user = userService.getByLogin(userDto.getLogin());
        if (user == null) {
            userService.registration(userDto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody UserDto userDto) {
        userService.update(userDto);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody UserDto userDto) {
        boolean flag = userService.isAuthorized(userDto.getLogin(), userDto.getPassword());
        return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
    }
}
