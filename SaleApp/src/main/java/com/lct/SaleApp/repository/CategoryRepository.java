package com.lct.SaleApp.repository;

import com.lct.SaleApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    public List<Category> findByActiveTrue();

    boolean existsByName(String name);

    @Query("SELECT c FROM Category c WHERE c.id LIKE :categoryId")
    Category getById(String categoryId);


}
