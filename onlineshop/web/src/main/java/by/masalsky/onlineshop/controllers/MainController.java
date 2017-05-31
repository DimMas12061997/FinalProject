package by.masalsky.onlineshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/")
    public String home(){
        return "WELCOME!!!";
    }

}
