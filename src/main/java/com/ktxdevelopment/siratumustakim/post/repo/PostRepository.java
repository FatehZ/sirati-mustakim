package com.ktxdevelopment.siratumustakim.post.repo;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer>, PagingAndSortingRepository<Post, Integer>, CrudRepository<Post, Integer> {
    @Query("select p from post p where p.viewed >= ?1")
    Optional<List<Post>> findByViewed(Long viewed);
    Optional<Post> findByPostId(String postId);

    @Modifying
    @Query("INSERT INTO posts (id, post_id, title, subtitle, content, dateAdded, dateUpdated, viewed) " +
            "VALUES (:#{#post.id}, :#{#post.postId}, :#{#post.title}, :#{#post.subtitle}, :#{#post.content}, " +
            ":#{#post.dateAdded}, :#{#post.dateUpdated}, :#{#post.viewed})")
    Post insertPost(@Param("post") Post post);

}