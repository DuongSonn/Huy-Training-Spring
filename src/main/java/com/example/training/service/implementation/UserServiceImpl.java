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

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<User> getAllUser(){
        List<User> listUser = userRepository.findAll();
        return listUser;
    }

    @Override
    public void addUser(UserDTO userDTO){
        User addUser = mapper.map(userDTO,User.class);
        userRepository.save(addUser);
    }

    @Override
    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else {
            throw new IllegalStateException("No id founded");
        }
    }

    @Override
    public void getUserById(Long id){
        Optional<User> user = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with id " + id + " is not exist")));
    }

    @Transactional
    @Override
    public void updateUser(Long id, UserDTO userDTO){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with id "+ id + " is not exist"));
        User newUser = mapper.map(userDTO, User.class);
        userDTO.setId(user.getId());
        userRepository.save(newUser);
    }
}
