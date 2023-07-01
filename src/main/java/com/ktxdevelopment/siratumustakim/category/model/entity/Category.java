package com.ktxdevelopment.siratumustakim.category.model.entity;


import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryFullDto;
import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Entity(name = "category")
@Table(name = "categories")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @Id
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    @Lazy
    @OneToMany(mappedBy = "category")
    @JoinTable(
            name = "category_post",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private ArrayList<Post> posts;


    CategoryFullDto toDtoFull() {
        return new CategoryFullDto(categoryId, title, description, posts.stream().map(Post::toDto).collect(Collectors.toList()));
    }

    CategoryDto toDto() {
        return new CategoryDto(categoryId, title, description);
    }
}