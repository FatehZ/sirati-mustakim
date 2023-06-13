package com.ktxdevelopment.siratumustakim.post;


import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.service.PostService;
import com.ktxdevelopment.siratumustakim.util.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.RestResponse;
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
    public ResponseEntity<CustomResponseModel<List<Post>>> getAllPostsPaginated(
            @RequestParam(name = "p", defaultValue = "0") int page,
            @RequestParam(name = "l", defaultValue = "20") int limit) {

        return RestResponse.ok(postService.getPostsPaginated(page, limit));
    }

    @GetMapping("/posts/trending")
    public ResponseEntity<CustomResponseModel<List<Post>>> getTrendingPosts() {
        return RestResponse.ok(postService.getTrendingPosts());
    }
}
