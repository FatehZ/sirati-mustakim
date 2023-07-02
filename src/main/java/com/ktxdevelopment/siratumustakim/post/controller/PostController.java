package com.ktxdevelopment.siratumustakim.post.controller;


import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import com.ktxdevelopment.siratumustakim.post.model.response.PostResponse;
import com.ktxdevelopment.siratumustakim.post.service.PostService;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponseModel<List<PostLitResponse>>> getAllPostsPaginated(
            @RequestParam(name = "p", defaultValue = "0") int page,
            @RequestParam(name = "l", defaultValue = "30") int limit) {

        return RestResponse.ok(postService.getPostsPaginated(page, limit));
    }

    @GetMapping("/trending")
    public ResponseEntity<CustomResponseModel<List<PostLitResponse>>> getTrendingPosts() {
        return RestResponse.ok(postService.getTrendingPosts());
    }


    @GetMapping("/{postId}")
    public ResponseEntity<CustomResponseModel<PostResponse>> getPostById(@PathVariable String postId) {
        return RestResponse.ok(postService.getFullPostById(postId));
    }


    @GetMapping("/{postId}/lit")
    public ResponseEntity<CustomResponseModel<PostLitResponse>> getLitPostById(@PathVariable String postId) {
        return RestResponse.ok(postService.getLitPostById(postId));
    }
}
