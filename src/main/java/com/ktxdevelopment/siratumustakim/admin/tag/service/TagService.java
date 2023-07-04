package com.ktxdevelopment.siratumustakim.admin.tag.service;

import com.ktxdevelopment.siratumustakim.admin.tag.model.response.TagResponse;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TagService{
    void insertTag(TagDto tag);

    void deleteTag(String id);
}
