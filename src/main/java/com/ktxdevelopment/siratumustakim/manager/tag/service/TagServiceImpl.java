package com.ktxdevelopment.siratumustakim.manager.tag.service;

import com.ktxdevelopment.siratumustakim.manager.tag.repo.TagRepository;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public void insertTag(TagDto tag) {
        tagRepository.save(Tag.builder().tagId(tag.getTagId())
                .title(tag.getTitle())
                .description(tag.getDescription())
                .posts(new ArrayList<>())
                .build()
        );
    }

    @Override
    public void deleteTag(String tagId) {
        tagRepository.deleteTagByTagId(tagId);
    }
}
