package com.example.INGProject.controller;

import com.example.INGProject.controller.dto.CreateProductReqDTO;
import com.example.INGProject.controller.dto.CreateProductResDTO;
import com.example.INGProject.controller.dto.GetProductResDTO;
import com.example.INGProject.domain.ProductService;
import com.example.INGProject.domain.model.ProductModel;
import com.example.INGProject.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired(required = true)
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public ResponseEntity<CreateProductResDTO> createProduct(@RequestBody CreateProductReqDTO createProductReqDTO){
        ProductModel productModel = productMapper.createProductReqDTOToProductModel(createProductReqDTO);
        ProductModel createProduct = productService.create(productModel);
        logger.info("The Created Product is: {}", createProduct);
        return ResponseEntity.ok(productMapper.productModelToCreateProductResDTO(createProduct));
    }


    @GetMapping
    public ResponseEntity<List<GetProductResDTO>> getAllProducts(){
        List<ProductModel> products = productService.getAll();
        List<GetProductResDTO> productsResDTO = new ArrayList<>();
        products.forEach(entity -> productsResDTO.add(productMapper.productModelToGetProductResDTO(entity)));
        logger.info("List of products: {}", products);
        return ResponseEntity.ok(productsResDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResDTO> getProductById(@PathVariable UUID id){
        ProductModel productModel = productService.getById(id);
        logger.info("The selected product is: {}", productModel);
        return ResponseEntity.ok(productMapper.productModelToGetProductResDTO(productModel));
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<GetProductResDTO> getProductByName(@PathVariable String name){
        ProductModel productModel = productService.getByName(name);
        logger.info("Product: {}", productModel);
        return ResponseEntity.ok(productMapper.productModelToGetProductResDTO(productModel));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id){
        productService.getById(id);
        return ResponseEntity.ok().build();
    }

}
