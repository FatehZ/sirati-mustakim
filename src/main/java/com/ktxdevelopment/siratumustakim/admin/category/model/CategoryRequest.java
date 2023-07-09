package com.ktxdevelopment.siratumustakim.admin.category.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CategoryRequest {

    private String categoryId;
    private String title;
    private String description;
    private String imageUrl;
}
