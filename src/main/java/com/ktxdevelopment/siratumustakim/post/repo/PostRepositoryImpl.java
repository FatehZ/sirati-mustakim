package com.ktxdevelopment.siratumustakim.post.repo;


import com.ktxdevelopment.siratumustakim.auth.user.model.dto.UserLitDto;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @SneakyThrows
    @Override
    public Optional<PostLitDto> findPostLitById(String postId) {

        String query = "SELECT p.post_id AS postId, p.title, p.subtitle " +
                "FROM post p " +
                "WHERE p.postId = ?";

        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(PostLitDto.class), postId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<PostDto> findPostFullById(String postId) {
        String query = "SELECT p.post_id AS postId, p.title, p.subtitle, u.username AS authorName, u.user_id AS authorUserId " +
                "FROM post p " +
                "JOIN user u ON p.user_id = u.user_id " +
                "WHERE p.post_id = ?";

        return jdbcTemplate.query(query, ps -> ps.setString(1, postId), rs -> {
            if (rs.next()) {
                PostDto postDto = new PostDto();
                postDto.setPostId(rs.getString("postId"));
                postDto.setTitle(rs.getString("title"));
                postDto.setSubtitle(rs.getString("subtitle"));

                UserLitDto userDto = new UserLitDto();
                userDto.setUsername(rs.getString("authorName"));
                userDto.setUserId(rs.getString("authorUserId"));
                postDto.setAuthor(userDto);

                return Optional.of(postDto);
            } else {
                return Optional.empty();
            }
        });
    }

    @Override
    public Optional<List<PostLitDto>> getAllPaginated(int page, int limit) {
        String query = "SELECT post_id AS postId, title, subtitle " +
                "FROM posts " +
                "ORDER BY date_created " +
                "LIMIT ? OFFSET ?";

        int offset = (page - 1) * limit;

        try {
            return Optional.of(jdbcTemplate.query(query, new BeanPropertyRowMapper<>(PostLitDto.class), limit, offset));
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}