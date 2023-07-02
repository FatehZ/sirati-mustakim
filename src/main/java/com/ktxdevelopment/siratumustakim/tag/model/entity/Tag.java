package com.ktxdevelopment.siratumustakim.tag.model.entity;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagFullDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity(name ="tag")
@Table(name = "tags")
//@Entity(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {

    @Id
    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "title")
    private String title;

    @Lazy
    @ManyToMany(mappedBy = "tags")
    @JoinTable(
            name = "tag_post",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<Post> posts;


    @Column(name = "description")
    private String description;

    TagFullDto toDtoFull() {
        return new TagFullDto(tagId, title, description, posts);
    }

    public TagDto toDto() {
        return new TagDto(tagId, title, description);
    }
}