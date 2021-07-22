package com.example.training.service.implementation;

import com.example.training.dto.UserDTO;
import com.example.training.entity.User;
import com.example.training.repository.interfaces.UserRepository;
import com.example.training.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addUser(User user){
        UserDTO UserDTO = mapper.map(user,UserDTO.class);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO){
        User user = userRepository.getById(id);
        User updateUser = mapper.map(userDTO,User.class);
        updateUser.setId(user.getId());
        userRepository.save(updateUser);
    }
}
