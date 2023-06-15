package com.ktxdevelopment.siratumustakim.tag.controller;


import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.exceptions.TagNotFoundException;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import com.ktxdevelopment.siratumustakim.tag.service.TagService;
import com.ktxdevelopment.siratumustakim.util.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/tags")
public class TagController {

    private TagService tagService;

    @GetMapping("/")
    public ResponseEntity<CustomResponseModel<List<Tag>>> getAllCategories() {
        return RestResponse.ok(tagService.getAllTags());
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<CustomResponseModel<Tag>> getTags(
            @PathVariable String tagId)
            throws TagNotFoundException {
        return RestResponse.ok(tagService.getTagByTagId(tagId));
    }
}
