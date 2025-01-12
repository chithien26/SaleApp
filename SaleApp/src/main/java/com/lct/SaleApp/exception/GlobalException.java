package com.lct.SaleApp.exception;

import com.lct.SaleApp.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> handlingRuntimeExeption(RuntimeException exception){
        return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), null));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingArgumentNotValidExceptionExeption(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.BAD_REQUEST.value(), exception.getFieldError().getDefaultMessage(), null));
    }
}
