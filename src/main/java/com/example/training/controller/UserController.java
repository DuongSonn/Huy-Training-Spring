package com.example.training.controller;

import com.example.training.dto.UserDTO;
import com.example.training.entity.User;
import com.example.training.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO){
        userService.updateUser(id,userDTO);
    }
}
