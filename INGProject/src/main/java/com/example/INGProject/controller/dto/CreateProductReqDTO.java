package com.example.INGProject.controller.dto;

import lombok.Data;

@Data
public class CreateProductReqDTO {
    public String name;
    public Integer price;
    public Integer lot;
}
