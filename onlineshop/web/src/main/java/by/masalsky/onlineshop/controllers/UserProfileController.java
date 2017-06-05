package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.UserProfileDto;
import by.masalsky.onlineshop.security.CustomUserDetails;
import by.masalsky.onlineshop.services.interfaces.IUserProfileService;
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
@RequestMapping("/userProfile")
public class UserProfileController {
    @Autowired
    private IUserProfileService userProfileService;
    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserProfileDto>> getAllUserProfiles() {
        List<UserProfileDto> list = null;
        UserProfileDto user = null;
        String role = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRole();
        if (role.equals("ADMINISTRATOR")) {
            list = userProfileService.getAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserProfileDto> getUserProfileById(@PathVariable("id") Integer id) {
        UserProfileDto user = null;
        String role = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRole();
        if (role.equals("ADMINISTRATOR")) {
            user = userProfileService.getByUserId(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            int idUser = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            if (idUser == id) {
                user = userProfileService.getByUserId(id);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserProfile(@PathVariable("id") Integer id) {
        UserProfileDto user = null;
        String role = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRole();
        if (role.equals("ADMINISTRATOR")) {
            user = userProfileService.getById(id);
            if (user != null) {
                userProfileService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else
                return new ResponseEntity<>("There is no such profile", HttpStatus.BAD_REQUEST);
        } else {
            int idUser = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            user = userProfileService.getByUserId(idUser);
            if (idUser == user.getUser()) {
                if (user != null) {
                    userProfileService.delete(id);
                    return new ResponseEntity<>(HttpStatus.OK);
                } else
                    return new ResponseEntity<>("There is no such profile", HttpStatus.BAD_REQUEST);
            } else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUserProfile(@RequestBody UserProfileDto userDto) {
        int idUser = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        userDto.setUser(idUser);
        int flag = userProfileService.save(userDto);
        if (flag != -1)
            return new ResponseEntity<Void>(HttpStatus.OK);
        else
            return new ResponseEntity<>("Profile for this user already exists", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUserProfile(@PathVariable("id") Integer id, @RequestBody UserProfileDto userDto) {
        UserProfileDto userDtoTmp = null;
        String role = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRole();
        int idUser = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if (role.equals("ADMINISTRATOR")) {
            userDto.setId(id);
            userDto.setUser(userProfileService.getById(id).getUser());
            userProfileService.update(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            userDtoTmp = userProfileService.getByUserId(idUser);
            if (userDtoTmp != null) {
                userDto.setId(id);
                userDto.setUser(userDtoTmp.getUser());
                userProfileService.update(userDto);
                return new ResponseEntity<>(HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
