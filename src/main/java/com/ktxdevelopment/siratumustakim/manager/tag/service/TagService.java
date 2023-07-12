package com.ktxdevelopment.siratumustakim.manager.tag.service;

import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import org.springframework.stereotype.Service;


@Service
public interface TagService{
    void insertTag(TagDto tag);

    void deleteTag(String id);
}
