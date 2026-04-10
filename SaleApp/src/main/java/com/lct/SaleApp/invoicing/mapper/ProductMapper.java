package com.lct.SaleApp.invoicing.mapper;

import com.lct.SaleApp.invoicing.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.invoicing.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(RequestCreateProduct requestCreateProduct);
}
