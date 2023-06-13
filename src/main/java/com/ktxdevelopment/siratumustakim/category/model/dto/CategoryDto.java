package com.ktxdevelopment.siratumustakim.category.model.dto;

import com.ktxdevelopment.siratumustakim.auth.user.model.User;
import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Builder
@Data
public class CategoryDto {
        private Integer id;
        private String categoryId;
        private String title;
};

