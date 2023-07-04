package com.ktxdevelopment.siratumustakim.admin.category.service;

import com.ktxdevelopment.siratumustakim.admin.category.repo.CategoryRepository;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.exceptions.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void insertCategory(CategoryDto category) {
        categoryRepository.save(Category.builder().categoryId(category.getCategoryId())
                        .title(category.getTitle())
                        .description(category.getDescription())
                        .posts(new ArrayList<>())
                        .build()
        );
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryRepository.deleteCategoryByCategoryId(categoryId);
    }
}