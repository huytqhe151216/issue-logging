package com.rabiloo.issue_logging.repositories;

import com.rabiloo.issue_logging.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(int id);
}
