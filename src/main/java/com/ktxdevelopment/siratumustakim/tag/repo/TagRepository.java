package com.ktxdevelopment.siratumustakim.tag.repo;

import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Optional<Tag> findTagByTagId(String id);
}
