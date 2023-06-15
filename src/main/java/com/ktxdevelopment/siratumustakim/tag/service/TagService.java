package com.ktxdevelopment.siratumustakim.tag.service;

import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;

import java.util.List;

public interface TagService{
    List<Tag> getAllTags();

    Tag findTagByTagId(String tagId);
}
