package com.ktxdevelopment.siratumustakim.admin.category.service;

import com.ktxdevelopment.siratumustakim.admin.category.model.CategoryRequest;
import com.ktxdevelopment.siratumustakim.admin.category.repo.CategoryRepository;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.util.img.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;


@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void insertCategory(CategoryRequest category) {

        String image;

        try {
            image = ImageUtils.imageToBase64(category.getImageUrl());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        categoryRepository.save(Category.builder().categoryId(category.getCategoryId())
                        .title(category.getTitle())
                        .description(category.getDescription())
                        .image(image)
                        .posts(new ArrayList<>())
                        .build()
        );
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryRepository.deleteCategoryByCategoryId(categoryId);
    }
}