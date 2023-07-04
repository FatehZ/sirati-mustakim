package com.ktxdevelopment.siratumustakim.admin.tag.controller;


import com.ktxdevelopment.siratumustakim.admin.category.service.CategoryService;
import com.ktxdevelopment.siratumustakim.admin.tag.model.response.TagResponse;
import com.ktxdevelopment.siratumustakim.admin.tag.service.TagService;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/admin/tags")
@RequiredArgsConstructor
public class TagController {

    private TagService tagService;

    @PostMapping("/add")
    private ResponseEntity<String> insertNewTag(@RequestBody TagDto tag) {
        tagService.insertTag(tag);
        return ResponseEntity.ok("Added successfully");
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteTag(@PathVariable String id) {
        tagService.deleteTag(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
