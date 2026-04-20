package com.lct.SaleApp.order.entity;

import com.lct.SaleApp.common.entity.BaseModel;
import com.lct.SaleApp.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @OneToOne
    User user;
    @OneToMany(mappedBy = "cart")
    List<CartItem> cartItems = new ArrayList<>();
}
