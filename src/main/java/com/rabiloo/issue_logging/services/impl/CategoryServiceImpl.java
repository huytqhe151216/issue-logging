package com.rabiloo.issue_logging.services.impl;

import com.rabiloo.issue_logging.domain.Category;
import com.rabiloo.issue_logging.repositories.CategoryRepository;
import com.rabiloo.issue_logging.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public boolean deleteCategory(int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int id, String name) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(name);
            return categoryRepository.save(category);
        }).orElse(null);
    }

    @Override
    public Category getCategory(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
