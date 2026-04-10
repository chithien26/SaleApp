package com.lct.SaleApp.customer.mapper;

import com.lct.SaleApp.customer.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.customer.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(RequestCreateProduct requestCreateProduct);
}
