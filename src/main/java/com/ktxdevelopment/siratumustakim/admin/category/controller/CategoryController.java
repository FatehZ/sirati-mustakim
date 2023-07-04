package com.ktxdevelopment.siratumustakim.admin.category.controller;


import com.ktxdevelopment.siratumustakim.admin.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.admin.category.service.CategoryService;
import com.ktxdevelopment.siratumustakim.exceptions.CategoryNotFoundException;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/category")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponseModel<List<Category>>> getAllCategories() {
        return RestResponse.ok(categoryService.getAllCategories());
    }

    @GetMapping("/get/{categoryId}")
    public ResponseEntity<CustomResponseModel<Category>> getTrendingPosts(@PathVariable String categoryId) throws CategoryNotFoundException {
        return RestResponse.ok(categoryService.getCategoryByCategoryId(categoryId));
    }
}
