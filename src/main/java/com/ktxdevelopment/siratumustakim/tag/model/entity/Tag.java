package com.ktxdevelopment.siratumustakim.tag.model.entity;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;

@Table(name = "tags")
//@Entity(name = "tag")
@Data
@Builder
public class Tag {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "tags")
    private ArrayList<Post> posts;
}