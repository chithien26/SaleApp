package com.lct.SaleApp.purchasing.mapper;

import com.lct.SaleApp.purchasing.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.purchasing.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(RequestCreateProduct requestCreateProduct);
}
