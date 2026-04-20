package com.lct.SaleApp.order.entity;

import com.lct.SaleApp.common.entity.BaseModel;
import com.lct.SaleApp.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
    Double price;
    int quantity;

}
