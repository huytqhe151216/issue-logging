package com.rabiloo.issue_logging.DTO.Project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCreateRequestDTO {
    private String name;
    private String code;
    private String description;
}
