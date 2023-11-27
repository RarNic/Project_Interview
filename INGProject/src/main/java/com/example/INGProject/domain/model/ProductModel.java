package com.example.INGProject.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductModel {
    private UUID id;
    private String name;
    private Integer price;
    private Integer lot;
}
