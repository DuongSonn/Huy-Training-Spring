package com.example.training.service.interfaces;

import com.example.training.dto.UserDTO;
import com.example.training.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    void addUser(UserDTO userDTO);
    void deleteUser(Long id);
    void getUserById(Long id);
    void updateUser(Long id, UserDTO userDTO);
}
