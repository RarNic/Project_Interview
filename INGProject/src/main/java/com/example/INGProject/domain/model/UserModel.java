package com.example.INGProject.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
