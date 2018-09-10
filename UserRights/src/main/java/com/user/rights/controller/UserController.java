package com.user.rights.controller;


import com.user.rights.dto.UserDTO;
import com.user.rights.service.UserService;
import com.user.rights.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getuser")
    public UserDTO getUser(@PathVariable("id") Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllBranch() {
        return userService.getAllUser();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long userId) {
        if (!userService.delete(userId)) {
            return "Deleted";
        } else
        return "Unable to Delete";
    }

    @PostMapping(value = "/create")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping(value = "/update")
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @GetMapping("/sample")
    public String getHi(){
        return "Hi";
    }


}
