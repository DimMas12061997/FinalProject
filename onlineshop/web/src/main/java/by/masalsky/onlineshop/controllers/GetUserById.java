package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.entities.User;
import by.masalsky.onlineshop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class GetUserById {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllArticles() {
        List<User> list = userService.getAll();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
}
