package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.BlackListDto;
import by.masalsky.onlineshop.services.interfaces.IBlackListService;
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
@RequestMapping("/blackList")
public class BlackListController {
    @Autowired
    private IBlackListService blackListService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BlackListDto>> getAllUsersFromBlackList() {
        List<BlackListDto> list = blackListService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BlackListDto> getUserByIdFromBlackList(@PathVariable("id") Integer id) {
        BlackListDto user = null;
        user = blackListService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteFromBlackList(@PathVariable("id") Integer id) {
        BlackListDto blackList = blackListService.getById(id);
        if (blackList != null) {
            blackListService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>("This user does not have a blacklist", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addUserInBlackList(@RequestBody BlackListDto blackListDto) {
        int flag = blackListService.save(blackListDto);
        if (flag != -1)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>("User can not add to blacklist", HttpStatus.BAD_REQUEST);
    }
}
