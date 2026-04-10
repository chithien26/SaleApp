package com.lct.SaleApp.customer.entity;

import com.lct.SaleApp.customer.dto.enumClass.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(unique = true, nullable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "phone_number")
    String phoneNunber;
    String email;
    @Column(name = "date_of_birth")
    LocalDate dob;
    String avatar;
    @Enumerated(EnumType.STRING)
    Role role;

}
