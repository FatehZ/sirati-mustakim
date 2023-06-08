package com.ktxdevelopment.siratumustakim.tag.model.entity;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;

@Table(name = "tags")
//@Entity(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Lazy
    @ManyToMany(mappedBy = "tags")
    private ArrayList<Post> posts;

    private String description;
    TagDto toDtoWithPosts() {
        return new TagDto(id, title, description, posts);
    }

    TagDto toDto() {
        return new TagDto(id, title, description);
    }
}