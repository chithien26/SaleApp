package com.lct.SaleApp.dto.request.userRequest;

import com.lct.SaleApp.dto.enumClass.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestCreateUser {
    @Column(unique = true)
    @NotEmpty(message = "Username is not empty!")
    String username;
    @Size(min = 8, max = 16, message = "Password 8 - 16 characters!")
    @NotEmpty(message = "Password is not empty!")
    String password;
    @Size(min = 8, max = 16, message = "Password 8 - 16 characters!")
    @NotEmpty(message = "Confirm password is not empty!")
    String confirmPassword;
    @Column(name = "first_name")
    @NotEmpty(message = "First name is not empty!")
    String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "Last name is not empty!")
    String lastName;
    @Size(min = 10, max = 10, message = "Phone number must have 10 characters!")
    @Column(name = "phone_number")
    String phoneNunber;
    @Email(message = "Email: ...@gmail.com")
    @NotEmpty(message = "Email is not empty!")
    String email;
    @Column(name = "date_of_birth")
    String dob;
    String avatar;
    Role role = Role.ROLE_USER;

}
