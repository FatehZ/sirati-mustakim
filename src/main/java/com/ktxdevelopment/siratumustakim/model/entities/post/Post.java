package com.ktxdevelopment.siratumustakim.model.entities.post;

import com.ktxdevelopment.siratumustakim.model.entities.category.Category;
import com.ktxdevelopment.siratumustakim.model.entities.tag.Tag;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;

@Builder
@Data
//@Entity(name = "post")
@Table(name = "post")
public class Post {

        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id")
        String id;

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
        ArrayList<String> authors; //todo

        @Column(name = "date")
        String date;

        @Column(name = "references")
        ArrayList<String> references;

        @Column(name = "additional_posts")
        ArrayList<String> additionalPostIds;

        @Column(name = "viewed")
        Long viewed;
}