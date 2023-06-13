package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    PostRepository postRepository;

    @Override
    public List<Post> getPostsPaginated(int page, int limit) {
        return null;
    }

    @Override
    public List<Post> getTrendingPosts() {
        return null;
    }
}
