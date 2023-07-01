package com.ktxdevelopment.siratumustakim.tag.service;

import com.ktxdevelopment.siratumustakim.tag.model.response.TagResponse;

import java.util.List;

public interface TagService{
    List<TagResponse> getAllTags();

    TagResponse getTagByTagId(String tagId);
}
