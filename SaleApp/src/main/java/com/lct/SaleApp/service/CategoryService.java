package com.lct.SaleApp.service;


import com.lct.SaleApp.dto.request.categoryRequest.RequestCreateCategory;
import com.lct.SaleApp.dto.request.categoryRequest.RequestUpdateCategory;
import com.lct.SaleApp.entity.Category;
import com.lct.SaleApp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public List<Category> getActiveCategory(){
        return categoryRepository.findByActiveTrue();
    }


    public Category getCategory(String categoryId){
        if(!categoryRepository.existsById(categoryId))
        {
            throw new RuntimeException("Category not found!");
        }
        return categoryRepository.getById(categoryId);
    }

    public List<Category> getCategoryByParent(String parentId){
        return getCategory(parentId).getListChildren();
    }

    public Category createCategory(RequestCreateCategory request){
        if (categoryRepository.existsByName(request.getName())){
            throw new RuntimeException("Category existed!");
        }

        Category c = new Category();
        c.setName(request.getName());
        c.setImage(request.getImage());
        c.setDescription(request.getDescription());
        c.setParent(categoryRepository.getById(request.getParent()));
        categoryRepository.save(c);
        return c;
    }

    public Category updateCategory(String categoryId, RequestUpdateCategory request){
        if (!categoryRepository.existsById(categoryId)){
            throw new RuntimeException("Category not found!");
        }

        Category c = categoryRepository.getById(categoryId);
        c.setName(request.getName());
        c.setImage(request.getImage());
        c.setDescription(request.getDescription());
        c.setParent(categoryRepository.getById(request.getParent()));
        categoryRepository.save(c);
        return c;
    }

    public void deleteCategory(String categoryId){
        if(!categoryRepository.existsById(categoryId)){
            throw new RuntimeException("Category not found!");
        }
        Category c = categoryRepository.getById(categoryId);
        c.setActive(false);
        categoryRepository.save(c);
    }
}
