package com.ktxdevelopment.siratumustakim.post.model.dto;

import com.ktxdevelopment.siratumustakim.category.Category;
import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.auth.user.model.User;
import com.nimbusds.jose.shaded.gson.Gson;
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
        Category category;
        HashMap<String, String> content;
        ArrayList<User> authors; //todo
        String date;
        ArrayList<String> references;
        ArrayList<String> additionalPostIds;
        Long viewed;
};

