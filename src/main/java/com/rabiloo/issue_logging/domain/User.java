package com.rabiloo.issue_logging.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor// lombok
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private boolean isAdmin = false;
    @Column(nullable = false)
    private boolean isDeleted = false;
}
