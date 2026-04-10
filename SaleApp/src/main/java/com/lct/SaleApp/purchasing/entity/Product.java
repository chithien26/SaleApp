package com.lct.SaleApp.purchasing.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String image;
    String description;
    Double price;
    int stockQuantity;
    @Column(name = "created_date")
    LocalDateTime createdDate;
    @Column(name = "updated_date")
    LocalDateTime updatedDate;
    boolean active;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;



}
