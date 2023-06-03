package com.ktxdevelopment.siratumustakim.service.post;

import com.ktxdevelopment.siratumustakim.model.post.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService extends CrudRepository<Post, Integer> {


//    @Query("SELECT id FROM posts")
    List<Post> getPostsPaginated(int page, int limit);



}
