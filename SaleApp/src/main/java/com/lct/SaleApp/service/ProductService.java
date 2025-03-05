package com.lct.SaleApp.service;

import com.lct.SaleApp.dto.request.ProductRequest.RequestCreateProduct;
import com.lct.SaleApp.entity.Product;
import com.lct.SaleApp.mapper.ProductMapper;
import com.lct.SaleApp.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product createProduct(RequestCreateProduct requestCreateProduct){
        Product product = productMapper.toProduct(requestCreateProduct);
        productRepository.save(product);
        return product;
    }
}
