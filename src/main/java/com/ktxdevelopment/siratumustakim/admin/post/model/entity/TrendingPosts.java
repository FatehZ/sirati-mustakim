package com.ktxdevelopment.siratumustakim.admin.post.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "trending_post")
@Table(name = "trending_post")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrendingPosts {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "post_id")
    String postId;

    String title;

    String subtitle;
}
