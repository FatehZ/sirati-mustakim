package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {


    List<Post> getPostsPaginated(int page, int limit);


    List<Post> getTrendingPosts();
}
