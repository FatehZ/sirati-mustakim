package com.ktxdevelopment.siratumustakim.tag.repo;

import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
