package com.lct.SaleApp.product.mapper;

import com.lct.SaleApp.product.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(RequestCreateProduct requestCreateProduct);
}
