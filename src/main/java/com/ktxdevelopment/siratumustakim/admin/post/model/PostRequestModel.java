package com.ktxdevelopment.siratumustakim.admin.post.model;

import com.ktxdevelopment.siratumustakim.admin.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.admin.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.auth.user.model.dto.UserLitDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
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