package com.lct.SaleApp.invoicing.repository;

import com.lct.SaleApp.invoicing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
