package com.lct.SaleApp.controller.api;

import com.lct.SaleApp.dto.request.categoryRequest.RequestCreateCategory;
import com.lct.SaleApp.dto.request.categoryRequest.RequestUpdateCategory;
import com.lct.SaleApp.dto.response.ApiResponse;
import com.lct.SaleApp.entity.Category;
import com.lct.SaleApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ApiResponse<List<Category>> getAllCategory(){
        return new ApiResponse(HttpStatus.OK.value(), "Success", categoryService.getAllCategory());
    }

    @GetMapping("/active")
    public ApiResponse<List<Category>> getActiveCategory(){
        return new ApiResponse(HttpStatus.OK.value(), "Success", categoryService.getActiveCategory());
    }

    @GetMapping("/{categoryId}")
    public ApiResponse<Category> getCategory(@PathVariable("categoryId") String categoryId){
        return new ApiResponse<>(HttpStatus.OK.value(), "Success", categoryService.getCategory(categoryId));
    }

    @GetMapping("/{categoryId}/children")
    public ApiResponse<List<Category>> getCategoryByParent(@PathVariable("categoryId") String categoryId){
        return new ApiResponse<>(HttpStatus.OK.value(), "Success", categoryService.getCategoryByParent(categoryId));
    }

    @PutMapping("/{categoryId}")
    public ApiResponse<Category> updateCategory(@PathVariable("categoryId") String categoryId, @RequestBody RequestUpdateCategory request){
        return new ApiResponse<>(HttpStatus.OK.value(), "Success", categoryService.updateCategory(categoryId, request));
    }

    @PostMapping
    public ApiResponse<Category> createCategory(@RequestBody RequestCreateCategory request){
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Succsess", categoryService.createCategory(request));
    }

    @PatchMapping("/{categoryId}")
    public ApiResponse<String> deleteCategory(@PathVariable("categoryId") String categoryId){
        categoryService.deleteCategory(categoryId);
        return new ApiResponse<>(HttpStatus.OK.value(),"Success", "Category deleted!");
    }
}
