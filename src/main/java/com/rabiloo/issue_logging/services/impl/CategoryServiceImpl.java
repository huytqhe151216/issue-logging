package com.rabiloo.issue_logging.services.impl;

import com.rabiloo.issue_logging.domain.Category;
import com.rabiloo.issue_logging.repositories.CategoryRepository;
import com.rabiloo.issue_logging.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean deleteCategory(int id) {
        log.info("Deleting category with id: {}", id);
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Category createCategory(String name) {
        log.info("Creating category with name: {}", name);
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int id, String name) {
        log.info("Updating category with id: {}", id);
        return categoryRepository.findById(id).map(category -> {
            category.setName(name);
            return categoryRepository.save(category);
        }).orElse(null);
    }

    @Override
    public Category getCategory(int id) {
        log.info("Getting category with id: {}", id);
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        log.info("Getting all categories");
        return categoryRepository.findAll();
    }
}
