package com.ktxdevelopment.siratumustakim.manager.post.service;

import com.ktxdevelopment.siratumustakim.manager.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import org.springframework.stereotype.Service;


@Service
public interface PostService {

    void setTrendingPosts(SetTrendingPostsRequest setTrendingPostsRequest) throws PostNotFoundException;

    void insertNewPost(PostRequestModel model);
}
