package com.ktxdevelopment.siratumustakim.manager.post.service;

import com.ktxdevelopment.siratumustakim.auth.user.repo.UserRepository;
import com.ktxdevelopment.siratumustakim.category.repo.CategoryRepository;
import com.ktxdevelopment.siratumustakim.manager.post.repo.ManagerPostRepository;
import com.ktxdevelopment.siratumustakim.manager.post.repo.TrendingPostRepository;
import com.ktxdevelopment.siratumustakim.manager.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.model.entity.TrendingPost;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import com.ktxdevelopment.siratumustakim.post.repo.PostRepository;
import com.ktxdevelopment.siratumustakim.tag.repo.TagRepository;
import com.nimbusds.jose.shaded.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;


@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    @Autowired ManagerPostRepository managerPostRepository;
    @Autowired TrendingPostRepository trendingPostRepository;
    @Autowired TagRepository tagRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired PostRepository postRepository;
    @Autowired UserRepository userRepository;

    @Override
    public void setTrendingPosts(SetTrendingPostsRequest setTrendingPostsRequest) {
        trendingPostRepository.deleteAll();
        for (String id: setTrendingPostsRequest.trends()) {
            var p = postRepository.findPostLitById(id).orElseThrow();
            trendingPostRepository.save(new TrendingPost(p.getPostId(), p.getTitle(), p.getSubtitle()));
        }
    }

    @Override
    public void insertNewPost(PostRequestModel p) {
        var c = categoryRepository.findCategoryByCategoryId(p.getCategory()).orElseThrow();
        var tags = p.getTags().stream().map(id -> tagRepository.findTagByTagId(id).orElseThrow()).toList();
        var author = userRepository.findByUserId(p.getAuthor()).orElseThrow();
        Gson gson = new Gson();
        String ref = gson.toJson(p.getReferences());

        managerPostRepository.save(new Post(p.getPostId(), p.getTitle(), p.getSubtitle(), tags, c, p.getContent(), author, new Date(), ref, 0L));
    }
}
