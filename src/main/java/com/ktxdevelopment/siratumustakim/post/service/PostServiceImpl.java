package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import com.ktxdevelopment.siratumustakim.post.model.response.PostResponse;
import com.ktxdevelopment.siratumustakim.post.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    PostRepository postRepository;

    @SneakyThrows
    @Override
    public List<PostLitResponse> getPostsPaginated(int page, int limit) {
        var posts  = postRepository.getAllPaginated(page, limit).orElseThrow(PostNotFoundException::new);
        return posts.stream().map(PostLitDto::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<PostLitResponse> getTrendingPosts() {
        return null;
    }

    @SneakyThrows
    @Override
    public PostResponse getFullPostById(String postId) {
        var dto = postRepository.findPostFullById(postId).orElseThrow(PostNotFoundException::new);
        return dto.toResponse();
    }

    @SneakyThrows
    @Override
    public PostLitResponse getLitPostById(String postId) {
        var dto = postRepository.findPostLitById(postId).orElseThrow(PostNotFoundException::new);
        return dto.toResponse();
    }


}
