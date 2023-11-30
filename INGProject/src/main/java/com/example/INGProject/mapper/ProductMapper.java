package com.example.INGProject.mapper;

import com.example.INGProject.controller.dto.CreateProductReqDTO;
import com.example.INGProject.controller.dto.CreateProductResDTO;
import com.example.INGProject.controller.dto.GetProductResDTO;
import com.example.INGProject.converter.UUIDConverter;
import com.example.INGProject.domain.model.ProductModel;
import com.example.INGProject.repository.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UUIDConverter.class)
public interface ProductMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price" , target = "price")
    @Mapping(source = "lot", target = "lot")
    ProductModel createProductReqDTOToProductModel(CreateProductReqDTO createProductReqDTO);

    @Mapping(source = "id", target = "id", qualifiedBy = UUIDConverter.ConvertUUIDToString.class)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "lot", target = "lot")
    CreateProductResDTO productModelToCreateProductResDTO(ProductModel productModel);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "lot", target = "lot")
    ProductModel productEntityToProductModel(ProductEntity product);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "lot", target = "lot")
    ProductEntity productModelToProductEntity(ProductModel productModel);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "lot", target = "lot")
    GetProductResDTO productModelToGetProductResDTO(ProductModel productModel);

}
