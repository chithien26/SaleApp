package com.lct.SaleApp.controller.admin;

import com.lct.SaleApp.dto.request.userRequest.RequestCreateUser;
import com.lct.SaleApp.dto.request.userRequest.RequestUpdateUser;
import com.lct.SaleApp.dto.response.ApiResponse;
import com.lct.SaleApp.entity.User;
import com.lct.SaleApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String users(Model model) {
//        return "layout/layout";
        return "content/user/UserManagement";
    }
//    @GetMapping
//    public ApiResponse<List<User>> getUsers(){
//        return new ApiResponse<>(HttpStatus.OK.value(), "Success", userService.getAllUser());
//    }
    @GetMapping("/active")
    public ApiResponse<List<User>> getActiveUsers(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Success", userService.getUsersActive());
    }

    @GetMapping("/{userId}")
    public ApiResponse<User> getUsers(@PathVariable("userId") String userId){
        return new ApiResponse<>(HttpStatus.OK.value(), "Success", userService.getUser(userId));
    }

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody @Valid RequestCreateUser request){
        return new ApiResponse<>(HttpStatus.CREATED.value(), "User created!", userService.createUser(request));
    }

    @PutMapping("/{userId}")
    public ApiResponse<User> updateUser(@PathVariable("userId") String userId, @RequestBody @Valid RequestUpdateUser request){
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated!", userService.updateUser(userId, request));
    }

    @PatchMapping("/{userId}")
    public ApiResponse<String> deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return new ApiResponse<>(HttpStatus.OK.value(),"Success", "User deleted!");
    }


}
