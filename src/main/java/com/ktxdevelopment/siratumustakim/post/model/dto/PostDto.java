package com.ktxdevelopment.siratumustakim.post.model.dto;

import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.auth.user.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Builder
@Data
public class PostDto {
        Integer id;
        String postId;
        String title;
        String subtitle;
        ArrayList<String> tagIds;
        ArrayList<TagDto> tags;
        CategoryDto category;
        HashMap<String, String> content;
        ArrayList<User> authors; //todo
        String date;
        ArrayList<String> references;
        ArrayList<String> additionalPostIds;
        Long viewed;
};