package com.ktxdevelopment.siratumustakim.tag.model.dto;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDto {

    private String id;
    private String description;
    private String title;
    private ArrayList<Post> posts;

    public TagDto(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


}
