package com.ktxdevelopment.siratumustakim.manager.post.repo;


import com.ktxdevelopment.siratumustakim.category.repo.CategoryRepository;
import com.ktxdevelopment.siratumustakim.manager.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CategoryRepository categoryRepository;

    @SneakyThrows
    public Optional<PostLitDto> findPostLitById(String postId) {
        String query = "SELECT p.post_id AS postId, p.title, p.subtitle FROM post p WHERE p.postId = ?";

        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(PostLitDto.class), postId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public void setTrendingPosts(SetTrendingPostsRequest trendingPostsRequest) {
        String sql = "INSERT INTO trending_post (post_id, title, subtitle) VALUES (?, ?, ?)";


        deleteAllTrendingPosts();
        for (String p: trendingPostsRequest.trends()) {
            var postLit = findPostLitById(p).orElseThrow();

            jdbcTemplate.update(
                    sql,
                    postLit.getPostId(),
                    postLit.getTitle(),
                    postLit.getSubtitle()
            );
        }

    }

    @Override
    public void insertNewPost(PostRequestModel postRequestModel) {

        var category = categoryRepository.findCategoryByCategoryId(postRequestModel.getCategory());
        var tag = categoryRepository.findCategoryByCategoryId(postRequestModel.getCategory());
    }

    public void deleteAllTrendingPosts() {
        String deleteQuery = "DELETE FROM trending_posts";
        jdbcTemplate.update(deleteQuery);
    }
}
