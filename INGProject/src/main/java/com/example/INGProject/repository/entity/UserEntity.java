package com.example.INGProject.repository.entity;

import com.example.INGProject.repository.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private Integer id;
    private String username;
    private String password;
    private String email;
    @Enumerated
    private Role role;
}
