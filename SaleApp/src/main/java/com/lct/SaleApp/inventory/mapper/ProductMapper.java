package com.lct.SaleApp.inventory.mapper;

import com.lct.SaleApp.inventory.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.inventory.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(RequestCreateProduct requestCreateProduct);
}
