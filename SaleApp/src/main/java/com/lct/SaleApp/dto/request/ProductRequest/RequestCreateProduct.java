package com.lct.SaleApp.dto.request.ProductRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestCreateProduct {
    String id;
    String name;
    String image;
    String description;
    Double price;
    int stockQuantity;
}
