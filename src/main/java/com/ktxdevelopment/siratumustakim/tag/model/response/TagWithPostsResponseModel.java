package com.ktxdevelopment.siratumustakim.tag.model.response;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagWithPostsResponseModel {
    private String id;
    private String title;
    private ArrayList<Post> posts;
    private String description;
}
