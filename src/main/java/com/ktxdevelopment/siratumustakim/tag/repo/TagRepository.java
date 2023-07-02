package com.ktxdevelopment.siratumustakim.tag.repo;

import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Optional<Tag> findTagByTagId(String id);
}
