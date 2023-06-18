package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {


    List<Post> getPostsPaginated(int page, int limit);


    List<Post> getTrendingPosts();

    Post insertNewProduct(PostRequestModel post);
}
