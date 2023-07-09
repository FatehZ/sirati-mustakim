package com.ktxdevelopment.siratumustakim.admin.post.service;

import com.ktxdevelopment.siratumustakim.admin.post.model.PostRequestModel;
import com.ktxdevelopment.siratumustakim.admin.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.admin.post.model.request.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.admin.post.model.response.PostResponse;
import com.ktxdevelopment.siratumustakim.admin.post.repo.PostRepository;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
