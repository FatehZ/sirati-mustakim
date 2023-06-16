package com.ktxdevelopment.siratumustakim.tag.service;

import com.ktxdevelopment.siratumustakim.exceptions.TagNotFoundException;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import com.ktxdevelopment.siratumustakim.tag.repo.TagRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagByTagId(String tagId) throws TagNotFoundException {
        var tag = tagRepository.findTagByTagId(tagId);
        if (tagId.isEmpty()) {throw new TagNotFoundException(); }
        return tagRepository.findTagByTagId(tagId).get();
    }
}
