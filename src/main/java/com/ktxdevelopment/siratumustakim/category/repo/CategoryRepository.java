package com.ktxdevelopment.siratumustakim.category.repo;

import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends
        CrudRepository<Category, Integer>,
        JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCategoryId(String categoryId);
}
