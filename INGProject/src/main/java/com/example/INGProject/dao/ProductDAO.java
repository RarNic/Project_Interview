package com.example.INGProject.dao;

import com.example.INGProject.domain.model.ProductModel;
import com.example.INGProject.mapper.ProductMapper;
import com.example.INGProject.repository.ProductRepository;
import com.example.INGProject.repository.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.internal.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductDAO {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    EntityManager entityManager;


    public ProductModel save(ProductModel productModel){
        ProductEntity productEntity = productMapper.productModelToProductEntity(productModel);
        ProductEntity createProductEntity = productRepository.save(productEntity);
        return productMapper.productEntityToProductModel(createProductEntity);
    }

    public ProductModel findByName(String name){
        Optional<ProductEntity> productEntity = productRepository.findByName(name);
        return productEntity.map(entity -> productMapper.productEntityToProductModel(entity)).orElse(null);
    }

    public ProductModel findById(UUID id){
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        return productEntity.map(entity -> productMapper.productEntityToProductModel(entity)).orElse(null);
    }

    public List<ProductModel> findAll(){
        List<ProductEntity> listEntities = productRepository.findAll();
        List<ProductModel> products = new ArrayList<>();
        listEntities.forEach(entity -> products.add(productMapper.productEntityToProductModel(entity)));
        return products;
    }

    public ProductModel updatePriceByName(String name, Integer price){
        ProductModel productModel = productMapper.productEntityToProductModel(productRepository.updatePriceByName(name, price));
        return productModel;
    }

    public void deleteProduct(UUID id){
        productRepository.deleteById(id);
    }

}
