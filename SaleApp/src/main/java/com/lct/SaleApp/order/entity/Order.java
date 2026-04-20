package com.lct.SaleApp.order.entity;

import com.lct.SaleApp.common.entity.BaseModel;
import com.lct.SaleApp.order.dto.enumClass.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orders")
public class Order extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    Double totalAmount;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
//    @Enumerated(EnumType.STRING)
//    PaymentMen paymentMethod;
//    @ManyToOne
//    @JoinColumn(name = "address_id")
//    Address address;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    User user;
//    boolean isPaid;

}
