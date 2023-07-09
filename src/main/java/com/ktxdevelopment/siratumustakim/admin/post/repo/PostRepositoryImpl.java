package com.ktxdevelopment.siratumustakim.admin.post.repo;


import com.ktxdevelopment.siratumustakim.admin.post.model.request.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.auth.user.model.dto.UserLitDto;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setTrendingPosts(SetTrendingPostsRequest trendingPostsRequest) throws PostNotFoundException {
        deleteAllTrendingPosts();
        var list = new ArrayList<PostLitDto>();
        for (String p: trendingPostsRequest.trends()) {
            var postLit = findPostLitById(p);
            list.add(postLit.orElseThrow(PostNotFoundException::new));
        }

    }

    public void deleteAllTrendingPosts() {
        String deleteQuery = "DELETE FROM trending_posts";
        jdbcTemplate.update(deleteQuery);
    }
}
