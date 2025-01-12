package com.lct.SaleApp.service;

import com.lct.SaleApp.dto.request.userRequest.RequestCreateUser;
import com.lct.SaleApp.dto.request.userRequest.RequestUpdateUser;
import com.lct.SaleApp.dto.response.RevertDate;
import com.lct.SaleApp.entity.User;
import com.lct.SaleApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public User createUser(RequestCreateUser request){
        if (userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("User existed!");
        }
        User u = new User();
        u.setUsername(request.getUsername());
        u.setPassword(request.getPassword());
        u.setFirstName(request.getFirstName());
        u.setLastName(request.getLastName());
        u.setPhoneNunber(request.getPhoneNunber());
        u.setRole(request.getRole());
        u.setDob(RevertDate.stringToDate(request.getDob()));
        u.setEmail(request.getEmail());
        u.setAvatar(request.getAvatar());
        userRepository.save(u);
        return u;
    }

    public User updateUser(String userId, RequestUpdateUser request){
        if (!userRepository.existsById(userId)){
            throw new RuntimeException("User not found!");
        }
        User u = userRepository.getUserById(userId);
        u.setPassword(request.getPassword());
        u.setFirstName(request.getFirstName());
        u.setLastName(request.getLastName());
        u.setPhoneNunber(request.getPhoneNunber());
        u.setRole(request.getRole());
        u.setDob(RevertDate.stringToDate(request.getDob()));
        u.setEmail(request.getEmail());
        u.setAvatar(request.getAvatar());
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
