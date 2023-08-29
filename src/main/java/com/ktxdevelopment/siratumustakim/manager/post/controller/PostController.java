package com.ktxdevelopment.siratumustakim.manager.post.controller;


import com.ktxdevelopment.siratumustakim.manager.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.manager.post.service.PostService;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager/post")
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

    @PostMapping("/{postId}/categorify")
    public ResponseEntity<CustomResponseModel<String>> addCategoryToPost(@PathVariable String postId, @RequestParam(name = "cid") String categoryId){
        postService.addCategoryToPost(postId, categoryId);
        return RestResponse.ok("Set Successfully");
    }


    @PostMapping("/{postId}/tagify")
    public ResponseEntity<CustomResponseModel<String>> addTagToPost(@PathVariable String postId, @RequestParam(name = "tid") String tagId){
        postService.addTagToPost(postId, tagId);
        return RestResponse.ok("Set Successfully");
    }
}
