package com.ktxdevelopment.siratumustakim.manager.post.repo;

import com.ktxdevelopment.siratumustakim.manager.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {

    void setTrendingPosts(SetTrendingPostsRequest trendingPostsRequest) throws PostNotFoundException;

    void insertNewPost(PostRequestModel postRequestModel);
}