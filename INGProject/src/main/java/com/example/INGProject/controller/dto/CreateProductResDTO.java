package com.example.INGProject.controller.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateProductResDTO {
    public UUID id;
    public String name;
    public Integer price;
    public Integer lot;
}
