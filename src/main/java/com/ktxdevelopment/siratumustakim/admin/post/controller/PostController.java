package com.ktxdevelopment.siratumustakim.admin.post.controller;


import com.ktxdevelopment.siratumustakim.admin.post.model.request.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.admin.post.model.response.PostResponse;
import com.ktxdevelopment.siratumustakim.admin.post.service.PostService;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/post")
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/trending")
    public ResponseEntity<CustomResponseModel<String>> setTrendingPosts(@RequestBody SetTrendingPostsRequest setTrendingPostsRequest) throws PostNotFoundException {
        postService.setTrendingPosts(setTrendingPostsRequest);
        return RestResponse.ok("Added successfully");
    }


    @PostMapping("/insert")
    public ResponseEntity<CustomResponseModel<PostResponse>> getPostById(@RequestBody PostDto postDto) {
        return RestResponse.ok(postService.getFullPostById(postDto));
    }


    @GetMapping("/{postId}/lit")
    public ResponseEntity<CustomResponseModel<PostLitResponse>> getLitPostById(@PathVariable String postId) {
        return RestResponse.ok(postService.getLitPostById(postId));
    }
}
