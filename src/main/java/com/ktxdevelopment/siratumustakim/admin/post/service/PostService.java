package com.ktxdevelopment.siratumustakim.admin.post.service;

import com.ktxdevelopment.siratumustakim.admin.post.model.request.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.admin.post.model.response.PostLitResponse;
import com.ktxdevelopment.siratumustakim.admin.post.model.response.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {


    List<PostLitResponse> getPostsPaginated(int page, int limit);

    List<PostLitResponse> getTrendingPosts();

    PostResponse getFullPostById(String postId);

    PostLitResponse getLitPostById(String postId);

    void setTrendingPosts(SetTrendingPostsRequest setTrendingPostsRequest);
}
