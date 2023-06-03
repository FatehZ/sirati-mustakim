package com.ktxdevelopment.siratumustakim.model.category;


import com.ktxdevelopment.siratumustakim.model.post.entity.Post;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;

//@Entity(name = "category")
@Table(name = "category")
@Builder
@Data
public class Category {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category")
    private ArrayList<Post> posts;
}