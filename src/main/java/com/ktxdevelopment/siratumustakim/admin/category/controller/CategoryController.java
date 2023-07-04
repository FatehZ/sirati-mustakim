package com.ktxdevelopment.siratumustakim.admin.category.controller;


import com.ktxdevelopment.siratumustakim.admin.category.service.CategoryService;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/category")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

  @PostMapping("/add")
  private ResponseEntity<String> insertNewCategory(@RequestBody CategoryDto category) {
      categoryService.insertCategory(category);
      return ResponseEntity.ok("Added successfully");
  }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
