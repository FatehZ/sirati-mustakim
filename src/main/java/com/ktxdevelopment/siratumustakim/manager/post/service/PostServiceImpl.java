package com.ktxdevelopment.siratumustakim.manager.post.service;

import com.ktxdevelopment.siratumustakim.manager.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.manager.post.repo.PostRepository;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    @Override
    public void setTrendingPosts(SetTrendingPostsRequest setTrendingPostsRequest) throws PostNotFoundException {
        postRepository.setTrendingPosts(setTrendingPostsRequest);
    }

    @Override
    public void insertNewPost(PostRequestModel model) {
        postRepository.insertNewPost(model);
    }
}
