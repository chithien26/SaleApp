package com.lct.SaleApp.entity;

import com.lct.SaleApp.dto.enumClass.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(unique = true)
    String username;
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
