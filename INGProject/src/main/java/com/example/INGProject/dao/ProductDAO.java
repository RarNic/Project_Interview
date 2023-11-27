package com.example.INGProject.dao;

import com.example.INGProject.domain.model.ProductModel;
import com.example.INGProject.mapper.ProductMapper;
import com.example.INGProject.repository.ProductRepository;
import com.example.INGProject.repository.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductDAO {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    EntityManager entityManager;


    public ProductModel save(ProductModel productModel){
        ProductEntity productEntity = productMapper.productModelToProductEntity(productModel);
        ProductEntity createProductEntity = productRepository.save(productEntity);
        return productMapper.ProductEntityToProductModel(createProductEntity);
    }

    public ProductModel findByName(String name){
        Optional<ProductEntity> productEntity = productRepository.findByName(name);
        return productEntity.map(entity -> productMapper.ProductEntityToProductModel(entity)).orElse(null);
    }

    public List<ProductEntity> findAll(){
        return entityManager.createQuery("SELECT p FROM Product p", ProductEntity.class).getResultList();
    }

    public void updatePriceByName(String name, Integer price){
        productRepository.updatePriceByName(name, price);
    }

    public void deleteByName(String name){
        productRepository.deleteByName(name);
    }


}
