package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import com.ktxdevelopment.siratumustakim.post.repo.PostRepository;
import com.ktxdevelopment.siratumustakim.util.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    PostRepository postRepository;

    @Override
    public List<Post> getPostsPaginated(int page, int limit) {
        return postRepository.findAll(Pageable.ofSize(limit).withPage(page).getSort());
    }

    @Override
    public List<Post> getTrendingPosts() {
        return postRepository.findByViewed(100L).orElseThrow();
    }

    @Override
    public PostDto insertNewProduct(PostDto post) {
        return PostMapper.INSTANCE.toDto(postRepository.insertPost(PostMapper.INSTANCE.toEntity(post)));
    }
}
