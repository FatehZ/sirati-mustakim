package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import com.ktxdevelopment.siratumustakim.post.model.response.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {


    List<PostLitResponse> getPostsPaginated(int page, int limit);


    List<PostLitResponse> getTrendingPosts();

    PostLitResponse insertNewProduct(PostRequestModel post);


    PostResponse getFullPostById(String postId);

    PostLitResponse getLitPostById(String postId);
}
