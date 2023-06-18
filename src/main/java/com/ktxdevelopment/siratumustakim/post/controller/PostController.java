package com.ktxdevelopment.siratumustakim.post.controller;


import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import com.ktxdevelopment.siratumustakim.post.service.PostService;
import com.ktxdevelopment.siratumustakim.util.mapper.PostMapper;
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
    public ResponseEntity<CustomResponseModel<List<Post>>> getAllPostsPaginated(
            @RequestParam(name = "p", defaultValue = "0") int page,
            @RequestParam(name = "l", defaultValue = "30") int limit) {

        return RestResponse.ok(postService.getPostsPaginated(page, limit));
    }

    @GetMapping("/trending")
    public ResponseEntity<CustomResponseModel<List<Post>>> getTrendingPosts() {
        return RestResponse.ok(postService.getTrendingPosts());
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponseModel<PostDto>> createNewPost(@RequestBody PostRequestModel post) {
        PostDto dto = PostMapper.INSTANCE.toDto(post);
        return RestResponse.ok(postService.insertNewProduct(dto));
    }
}
