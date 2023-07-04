package com.ktxdevelopment.siratumustakim.admin.category.service;

import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import org.springframework.stereotype.Service;


@Service
public interface CategoryService {

    void insertCategory(CategoryDto category);

    void deleteCategory(String id);
}
