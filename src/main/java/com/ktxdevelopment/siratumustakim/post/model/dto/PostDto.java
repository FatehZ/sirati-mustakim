package com.ktxdevelopment.siratumustakim.post.model.dto;

import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Builder
@Data
public class PostDto {
        String postId;
        String title;
        String subtitle;
//        ArrayList<String> tagIds;
        ArrayList<TagDto> tags;
        CategoryDto category;
        String content;
//        ArrayList<String> authorIds;
        ArrayList<User> authors;
        String date;
        ArrayList<String> references;
        ArrayList<String> additionalPostIds;
        Long viewed;
};