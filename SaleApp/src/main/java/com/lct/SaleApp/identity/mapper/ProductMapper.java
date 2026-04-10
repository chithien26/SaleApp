package com.lct.SaleApp.identity.mapper;

import com.lct.SaleApp.identity.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.identity.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(RequestCreateProduct requestCreateProduct);
}
