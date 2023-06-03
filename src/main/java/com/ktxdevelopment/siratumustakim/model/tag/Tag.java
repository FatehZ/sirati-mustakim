package com.ktxdevelopment.siratumustakim.model.tag;

import com.ktxdevelopment.siratumustakim.model.post.entity.Post;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;

@Table(name = "tag")
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