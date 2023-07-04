package com.ktxdevelopment.siratumustakim.admin.tag.service;

import com.ktxdevelopment.siratumustakim.admin.tag.model.response.TagResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TagService{
    List<TagResponse> getAllTags();

    TagResponse getTagByTagId(String tagId);
}
