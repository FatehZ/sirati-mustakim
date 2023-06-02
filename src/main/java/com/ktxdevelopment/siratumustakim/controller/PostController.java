package com.ktxdevelopment.siratumustakim.controller;


import com.ktxdevelopment.siratumustakim.model.entities.post.Post;
import com.ktxdevelopment.siratumustakim.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPostsPaginated(
            @RequestParam(name = "p", defaultValue = "0") int page,
            @RequestParam(name = "l", defaultValue = "20") int limit) {

        return ResponseEntity.ok(postService);
    }

    @GetMapping("/posts/trending")
    public ResponseEntity<List<Post>> getTrendingPosts() {
        return null;
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> insertNewPost() {
        return null;
    }

}
