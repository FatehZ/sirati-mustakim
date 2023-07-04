package com.ktxdevelopment.siratumustakim.admin.post.model.dto;

import com.ktxdevelopment.siratumustakim.admin.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.admin.post.model.response.PostResponse;
import com.ktxdevelopment.siratumustakim.admin.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.auth.user.model.dto.UserLitDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
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

    public PostResponse toResponse() {
            return new PostResponse(postId, title, subtitle, tags, category, content, author.toResponse(), date, references, viewed);
    }

//    public Post toEntity() {
//            return new Post(postId, title, subtitle, tags, null, content, null, date)
//    }
};