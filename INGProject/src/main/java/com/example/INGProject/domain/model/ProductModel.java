package com.example.INGProject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    private UUID id;
    private String name;
    private Integer price;
    private Integer lot;
}
