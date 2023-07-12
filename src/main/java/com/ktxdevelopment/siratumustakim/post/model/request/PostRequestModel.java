package com.ktxdevelopment.siratumustakim.post.model.request;

import com.ktxdevelopment.siratumustakim.auth.user.model.dto.UserLitDto;
import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequestModel {
    String postId;
    String title;
    String subtitle;
    List<String> tags;
    String category;
    String content;
    String author;
    List<String> references;
};