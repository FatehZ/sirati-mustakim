package com.ktxdevelopment.siratumustakim.admin.post.service;

import com.ktxdevelopment.siratumustakim.admin.post.model.PostRequestModel;
import com.ktxdevelopment.siratumustakim.admin.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PostService {


    void setTrendingPosts(SetTrendingPostsRequest setTrendingPostsRequest) throws PostNotFoundException;

    void insertNewPost(PostRequestModel model);
}
