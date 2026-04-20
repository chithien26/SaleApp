package com.lct.SaleApp.product.service;

import com.lct.SaleApp.product.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.product.entity.Product;
import com.lct.SaleApp.product.mapper.ProductMapper;
import com.lct.SaleApp.product.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductRepository productRepository;
//    ProductMapper productMapper;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

//    public Product createProduct(RequestCreateProduct requestCreateProduct){
//        Product product = productMapper.toProduct(requestCreateProduct);
//        productRepository.save(product);
//        return product;
//    }
}
