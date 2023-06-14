package com.ktxdevelopment.siratumustakim.category.service;

import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.exceptions.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryByCategoryId(String categoryId) throws CategoryNotFoundException;
}
