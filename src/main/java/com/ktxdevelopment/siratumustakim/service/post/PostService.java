package com.ktxdevelopment.siratumustakim.service.post;

import com.ktxdevelopment.siratumustakim.model.entities.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService extends CrudRepository<Post, Integer> {


    List<Post> getPostsPaginated(int page, int limit);



}
