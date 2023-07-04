package com.ktxdevelopment.siratumustakim.admin.category.model.response;

import com.ktxdevelopment.siratumustakim.admin.post.model.entity.Post;

import java.util.List;


public class CategoryFullResponse {
    private String categoryId;
    private String title;
    private String description;
    private List<Post> posts;
}
