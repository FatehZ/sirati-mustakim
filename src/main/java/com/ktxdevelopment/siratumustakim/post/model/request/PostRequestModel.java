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
    List<TagDto> tags;
    CategoryDto category;
    String content;
    UserLitDto author;
    Date date;
    List<String> references;
    Long viewed;

    public PostDto toDto() {
        return new PostDto(postId, title, subtitle, tags, category, content, author, java.sql.Date.valueOf(LocalDate.now()), references, 0L);
    }
};