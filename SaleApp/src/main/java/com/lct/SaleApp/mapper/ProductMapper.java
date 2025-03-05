package com.lct.SaleApp.mapper;

import com.lct.SaleApp.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(RequestCreateProduct requestCreateProduct);
}
