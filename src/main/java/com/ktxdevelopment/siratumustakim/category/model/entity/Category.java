package com.ktxdevelopment.siratumustakim.category.model.entity;


import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;

//@Entity(name = "category")
@Table(name = "categories")
@Builder
@Data
public class Category {

    @Id
    @GeneratedValue
    Integer id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "title")
    private String title;

    @Lazy
    @OneToMany(mappedBy = "category")
    private ArrayList<Post> posts;
}