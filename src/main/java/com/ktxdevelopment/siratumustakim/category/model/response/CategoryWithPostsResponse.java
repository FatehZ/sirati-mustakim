package com.ktxdevelopment.siratumustakim.category.model.response;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;

import java.util.ArrayList;

public class CategoryWithPostsResponse {
    private String categoryId;
    private String title;
    private ArrayList<Post> posts;
}
