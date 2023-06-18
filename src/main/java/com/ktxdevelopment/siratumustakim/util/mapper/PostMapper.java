package com.ktxdevelopment.siratumustakim.util.mapper;

import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "postId", source = "dto.postId")
    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "subtitle", source = "dto.subtitle")
    @Mapping(target = "content", source = "dto.content")
    @Mapping(target = "dateAdded", source = "dto.dateAdded")
    @Mapping(target = "dateUpdated", source = "dto.dateUpdated")
    @Mapping(target = "viewed", source = "dto.viewed")
    Post toEntity(PostDto dto);

    @Mapping(target = "postId", source = "dto.postId")
    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "subtitle", source = "dto.subtitle")
    @Mapping(target = "content", source = "dto.content")
    @Mapping(target = "dateAdded", source = "dto.dateAdded")
    @Mapping(target = "dateUpdated", source = "dto.dateUpdated")
    @Mapping(target = "viewed", source = "dto.viewed")
    PostDto toDto(PostRequestModel requestModel);

    @Mapping(target = "postId", source = "entity.postId")
    @Mapping(target = "title", source = "entity.title")
    @Mapping(target = "subtitle", source = "entity.subtitle")
    @Mapping(target = "content", source = "entity.content")
    @Mapping(target = "date", source = "entity.date")
    @Mapping(target = "viewed", source = "entity.viewed")
    PostDto toDto(Post entity);

    @Mapping(target = "dtoField", source = "entityField")
    PostDto toDTO(PostRequestModel entity);
}