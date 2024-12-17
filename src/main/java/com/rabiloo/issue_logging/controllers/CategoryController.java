package com.rabiloo.issue_logging.controllers;

import com.rabiloo.issue_logging.DTO.Category.CategoryCreatRequestDTO;
import com.rabiloo.issue_logging.common.models.ResponseResult;
import com.rabiloo.issue_logging.domain.Category;
import com.rabiloo.issue_logging.exceptions.NotFoundException;
import com.rabiloo.issue_logging.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseResult<Category> createCategory(@RequestBody CategoryCreatRequestDTO dto) {
        Category category = categoryService.createCategory(dto.getName());
        return ResponseResult.success("Category created successfully", category);
    }

    @PutMapping("/{id}")
    public ResponseResult<Category> updateCategory(@PathVariable Integer id, @RequestBody CategoryCreatRequestDTO dto) {
        Category updatedCategory = categoryService.updateCategory(id, dto.getName());

        if (updatedCategory != null) {
            return ResponseResult.success("Category updated successfully", updatedCategory);
        } else {
            return ResponseResult.error(404, "Category not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseResult<Void> deleteCategory(@PathVariable Integer id) {
        boolean isDeleted = categoryService.deleteCategory(id);
        if (isDeleted) {
            return ResponseResult.success("Category deleted successfully", null);
        } else {
            return ResponseResult.error(404, "Category not found");
        }
    }

    @GetMapping("/{id}")
    public ResponseResult<Category> getCategory(@PathVariable Integer id) {
        Category category = categoryService.getCategory(id);
        if (category == null) {
            throw new NotFoundException("Category with id " + id + " not found");
        }
        return ResponseResult.success("Category found", category);
    }

    @GetMapping()
    public ResponseResult<List<Category>> getAllCategories() {
        return ResponseResult.success("Categories found", categoryService.getAllCategories());
    }

}
