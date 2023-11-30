package com.example.INGProject.controller.dto;

import com.example.INGProject.repository.Role;
import lombok.Data;

@Data
public class CreateUserReqDTO {
    private String username;
    private String email;

    private Role role;

}
