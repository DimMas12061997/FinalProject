package by.masalsky.onlineshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/main")
    public String home(){
        return "Hello dima!";
    }

    @RequestMapping(value = "/qwe")
    public String qwe(){
        return "Hello qwe!";
    }

}
