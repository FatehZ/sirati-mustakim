package com.ktxdevelopment.siratumustakim.manager.tag.repo;

import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

    void deleteTagByTagId(String tagId);
}
