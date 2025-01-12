package com.lct.SaleApp.dto.request.userRequest;

import com.lct.SaleApp.dto.enumClass.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestCreateUser {
    @Column(unique = true)
    String username;
    @Size(min = 8, max = 16, message = "Password 8 - 16 characters!")
    String password;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Size(min = 10, max = 10, message = "Phone number must have 10 characters!")
    @Column(name = "phone_number")
    String phoneNunber;
    @Email(message = "Email: ...@gmail.com")
    String email;
    @Column(name = "date_of_birth")
    String dob;
    String avatar;
    Role role = Role.ROLE_USER;

}
