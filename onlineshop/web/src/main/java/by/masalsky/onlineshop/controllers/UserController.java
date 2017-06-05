package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.UserDto;
import by.masalsky.onlineshop.security.CustomUserDetails;
import by.masalsky.onlineshop.security.service.LoginService;
import by.masalsky.onlineshop.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        String role = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRole();
        if (role.equals("ADMINISTRATOR")) {
            List<UserDto> list = userService.getAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id) {
        UserDto user = null;
        String role = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRole();
        if (role.equals("ADMINISTRATOR")) {
            user = userService.getById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            int idUser = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            if (idUser == id) {
                user = userService.getById(id);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        UserDto user = userService.getByLogin(userDto.getLogin());
        if (user == null) {
            userService.save(userDto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else
            return new ResponseEntity<>("User with such login already exists", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable("id") Integer id, @RequestBody UserDto userDto) {
        String role = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRole();
        if (role.equals("ADMINISTRATOR")) {
            userDto.setId(id);
            userService.update(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            int idUser = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            if (id == idUser) {
                userDto.setId(id);
                userService.update(userDto);
                return new ResponseEntity<>(HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody UserDto userDto) {
        boolean flag = userService.isAuthorized(userDto.getLogin(), userDto.getPassword());
        if (flag == true) {
            loginService.authenticate(userDto.getLogin(), userDto.getPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>("Invalid Input. Try again.", HttpStatus.BAD_REQUEST);
    }
}
