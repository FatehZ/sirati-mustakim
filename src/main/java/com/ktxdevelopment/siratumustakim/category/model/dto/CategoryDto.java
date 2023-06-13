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
        Integer id;
        String postId;
        String title;
        String subtitle;
        ArrayList<String> tagIds;
        ArrayList<TagDto> tags;
        Category category;
        HashMap<String, String> content;
        ArrayList<User> authors; //todo
        String date;
        ArrayList<String> references;
        ArrayList<String> additionalPostIds;
        Long viewed;
};

