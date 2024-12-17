package com.rabiloo.issue_logging.services;

import com.rabiloo.issue_logging.domain.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(String name);

    Category updateCategory(int id, String name);

    boolean deleteCategory(int id);

    Category getCategory(int id);

    List<Category> getAllCategories();
}
