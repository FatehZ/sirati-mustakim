package com.ktxdevelopment.siratumustakim.tag.service;

import com.ktxdevelopment.siratumustakim.exceptions.TagNotFoundException;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import com.ktxdevelopment.siratumustakim.tag.model.response.TagResponse;
import com.ktxdevelopment.siratumustakim.tag.repo.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    TagRepository tagRepository;

    @Override
    public List<TagResponse> getAllTags() {
        List<TagDto> tags = tagRepository.findAll(Sort.by(Sort.Direction.ASC, "title")).stream().map(Tag::toDto).collect(Collectors.toList());;
        return tags.stream().map(TagDto::toResponse).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public TagResponse getTagByTagId(String tagId) {
        var dto = tagRepository.findTagByTagId(tagId).orElseThrow(TagNotFoundException::new).toDto();
        return dto.toResponse();
    }
}
