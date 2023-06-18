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

    @Mapping(target = "entityField", source = "dtoField")
    Post toEntity(PostDto dto);

    @Mapping(target = "dtoField", source = "entityField")
    PostDto toDTO(Post entity);

    @Mapping(target = "dtoField", source = "entityField")
    PostDto toDTO(PostRequestModel entity);
}