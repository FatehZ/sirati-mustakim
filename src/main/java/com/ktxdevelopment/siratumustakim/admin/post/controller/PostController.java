package com.ktxdevelopment.siratumustakim.admin.post.controller;


import com.ktxdevelopment.siratumustakim.admin.post.model.PostRequestModel;
import com.ktxdevelopment.siratumustakim.admin.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.admin.post.service.PostService;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
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
        return RestResponse.ok("Set successfully");
    }


    @PostMapping("/add")
    public ResponseEntity<CustomResponseModel<String>> insertNewPost(@RequestBody PostRequestModel post) {
        postService.insertNewPost(post);
        return RestResponse.ok("Set successfully");
    }
}
