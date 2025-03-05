package com.lct.SaleApp.controller.api;

import com.lct.SaleApp.dto.request.LoginRequest.LoginRequest;
import com.lct.SaleApp.dto.response.ApiResponse;
import com.lct.SaleApp.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping
    public ApiResponse<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Login Success!", authenticationService.login(loginRequest.getUsername(), loginRequest.getPassword()));
    }
}
