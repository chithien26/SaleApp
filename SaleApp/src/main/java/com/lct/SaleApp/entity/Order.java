package com.lct.SaleApp.entity;

import com.lct.SaleApp.dto.enumClass.OrderStatus;
import com.lct.SaleApp.dto.enumClass.PaymentMethod;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orders")
public class Order extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    Double totalAmount;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    boolean isPaid;

}
