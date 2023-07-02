package com.ktxdevelopment.siratumustakim.post.model.entity;

import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;
import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User author;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "references", columnDefinition = "TEXT")
    String references;

    @Column(name = "viewed")
    Long viewed;
}