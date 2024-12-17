package com.rabiloo.issue_logging.DTO.Category;

public class CategoryCreatRequestDTO {
    private String name;

    public CategoryCreatRequestDTO() {
    }

    public CategoryCreatRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
