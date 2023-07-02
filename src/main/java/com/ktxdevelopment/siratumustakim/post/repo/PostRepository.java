package com.ktxdevelopment.siratumustakim.post.repo;

import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository {
    Optional<PostLitDto> findPostLitById(@Param("postId") String postId);

    Optional<PostDto> findPostFullById(@Param("postId") String postId);

    Optional<List<PostLitDto>> getAllPaginated(int page, int limit);
}