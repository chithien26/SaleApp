package com.lct.SaleApp.service;

import com.lct.SaleApp.dto.request.userRequest.RequestCreateUser;
import com.lct.SaleApp.dto.request.userRequest.RequestUpdateUser;
import com.lct.SaleApp.dto.response.RevertDate;
import com.lct.SaleApp.entity.User;
import com.lct.SaleApp.mapper.UserMapper;
import com.lct.SaleApp.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;



    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public List<User> getUsersActive(){
        return userRepository.findByActiveTrue();
    }

    public User getUser(String userId){
        if (!userRepository.existsById(userId)){
            throw new RuntimeException("User not found!");
        }
        return userRepository.getUserById(userId);
    }

    public User getUserByUserName(String username){
        if (!userRepository.existsByUsername(username)){
            throw new RuntimeException("User not found!");
        }
        return userRepository.getUserByUsername(username);
    }

    public User createUser(RequestCreateUser request){
        if (userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username existed!");
        }
        if (!request.getPassword().equals(request.getConfirmPassword())){
            throw new RuntimeException("Password must be same confirm password!");
        }
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = userMapper.toUser(request);
        userRepository.save(user);
        return user;
    }

    public User updateUser(String userId, RequestUpdateUser request){
        if (!userRepository.existsById(userId)){
            throw new RuntimeException("User not found!");
        }
        User u = userRepository.getUserById(userId);
        userMapper.updateUser(u, request);
        userRepository.save(u);
        return u;
    }
    public void deleteUser(String userId){
        if(!userRepository.existsById(userId)){
            throw new RuntimeException("User not exist!");
        }
        User u = userRepository.getUserById(userId);
        u.setActive(false);
        userRepository.save(u);
    }
}
