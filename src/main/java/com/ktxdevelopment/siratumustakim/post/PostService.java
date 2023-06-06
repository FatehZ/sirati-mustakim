package com.ktxdevelopment.siratumustakim.post;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService extends CrudRepository<Post, Integer> {


//    @Query("SELECT id FROM posts")
    List<Post> getPostsPaginated(int page, int limit);



}
