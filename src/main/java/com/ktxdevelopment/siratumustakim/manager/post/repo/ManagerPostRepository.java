package com.ktxdevelopment.siratumustakim.manager.post.repo;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerPostRepository extends JpaRepository<Post, String> {
    
}
