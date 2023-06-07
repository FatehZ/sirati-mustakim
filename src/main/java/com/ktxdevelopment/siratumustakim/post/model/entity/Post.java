package com.ktxdevelopment.siratumustakim.post.model.entity;

import com.ktxdevelopment.siratumustakim.category.Category;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import com.ktxdevelopment.siratumustakim.auth.user.model.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;

@Builder
@Data
//@Entity(name = "posts")
@Table(name = "posts")
public class Post {

        @Id
        @GeneratedValue
        @Column(name = "id")
        Integer id;

        @Column(name = "post_id")
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
        String postId;

        @Column(name = "title")
        String title;

        @Column(name = "subtitle")
        String subtitle;

        @ManyToMany
        @JoinTable(
                name = "post_tag",
                joinColumns = @JoinColumn(name = "post_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id")
        )
        ArrayList<Tag> tags;

        @ManyToOne
        Category category;

        @Column(name = "content")
        String content;

        @ManyToMany
        ArrayList<User> authors; //todo

        @Column(name = "dateAdded")
        String dateAdded;


        @Column(name = "dateUpdated")
        String dateUpdated;

        @Column(name = "references")
        ArrayList<String> references;

        @Column(name = "additional_posts")
        ArrayList<String> additionalPostIds;

        @Column(name = "viewed")
        Long viewed;
}