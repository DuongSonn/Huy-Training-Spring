package com.example.training.service.interfaces;

import com.example.training.dto.UserDTO;
import com.example.training.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAllUser();
    Optional<User> findById(Long id);
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, UserDTO userDTO);
}
