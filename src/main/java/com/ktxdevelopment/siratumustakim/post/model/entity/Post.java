package com.ktxdevelopment.siratumustakim.post.model.entity;

import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "post")
@Table(name = "posts")
public class Post {

        @Id
        @Column(name = "post_id")
        String postId;

        @Column(name = "title")
        String title;

        @Column(name = "subtitle")
        String subtitle;

        @ManyToMany
        ArrayList<Tag> tags;

        @ManyToOne
        @JoinColumn(name = "category_id")
        Category category;

        @Column(name = "content", nullable = false, columnDefinition = "TEXT")
        String content;

        @ManyToMany
        @JoinTable(
                name = "user_post",
                joinColumns = @JoinColumn(name = "post_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id")
        )
        ArrayList<User> authors;

        @Column(name = "date_added")
        String dateAdded;

        @Column(name = "references")
        ArrayList<String> references;

        @Column(name = "viewed")
        Long viewed;

        public PostDto toDto() {
                return new PostDto(postId, title, subtitle, tags, category);
        }

        public PostLitDto toLitDto() {
                return new PostLitDto(postId, title, subtitle);
        }
}