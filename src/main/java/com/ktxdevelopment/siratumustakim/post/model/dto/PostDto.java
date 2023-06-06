package com.ktxdevelopment.siratumustakim.post.model.dto;

import com.ktxdevelopment.siratumustakim.category.Category;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.user.model.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;

@Builder
@Data
public class PostDto {
        Integer id;
        String postId;
        String title;
        String subtitle;
        ArrayList<TagDto> tags;
        Category category;
        String content;
        ArrayList<User> authors; //todo
        String date;
        ArrayList<String> references;
        ArrayList<String> additionalPostIds;
        Long viewed;
}