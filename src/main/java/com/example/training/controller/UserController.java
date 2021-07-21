package com.example.training.controller;

import com.example.training.dto.UserDTO;
import com.example.training.entity.User;
import com.example.training.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

    @DeleteMapping(path = "/delete")
    public void deleteUser(@RequestParam("id") Long id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "/update")
    public void updateUser(@RequestParam("id") Long id,
                           @RequestBody UserDTO userDTO){
        userService.updateUser(id,userDTO);
    }
}
