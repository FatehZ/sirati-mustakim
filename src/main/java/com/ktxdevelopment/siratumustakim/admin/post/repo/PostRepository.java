package com.ktxdevelopment.siratumustakim.admin.post.repo;

import com.ktxdevelopment.siratumustakim.admin.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.admin.post.model.request.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository {

    void setTrendingPosts(SetTrendingPostsRequest trendingPostsRequest) throws PostNotFoundException;

    void insertNewPost(PostRequestModel postRequestModel);
}