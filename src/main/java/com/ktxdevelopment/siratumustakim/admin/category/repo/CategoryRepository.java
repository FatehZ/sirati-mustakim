package com.ktxdevelopment.siratumustakim.admin.category.repo;

import com.ktxdevelopment.siratumustakim.admin.category.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>, JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCategoryId(String categoryId);
}
