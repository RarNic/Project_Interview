package com.example.INGProject.domain;

import com.example.INGProject.dao.ProductDAO;
import com.example.INGProject.domain.exception.NoProductsOrUsersExistsException;
import com.example.INGProject.domain.exception.ProductOrUserAlreadyExistsException;
import com.example.INGProject.domain.exception.ProductOrUserNotFoundException;
import com.example.INGProject.domain.exception.ProductIdOrUserIdDoesNotExistsException;
import com.example.INGProject.domain.model.ProductModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductModel create(ProductModel productModel){
        List<ProductModel> list = productDAO.findAll();
        boolean exist = list.stream().anyMatch(elem -> elem.getName().equals(productModel.getName()));
        if(exist){
            throw new ProductOrUserAlreadyExistsException();
        }
        ProductModel savedProduct = productDAO.save(productModel);
        logger.info("The add product: {}", savedProduct);
        return savedProduct;
    }

    public List<ProductModel> getAll(){
        List<ProductModel> products = productDAO.findAll();
        if(products.isEmpty()){
            throw new NoProductsOrUsersExistsException();
        }
        logger.info("The list of products: {}", products);
        return products;
    }

    public ProductModel getByName(String name){
        ProductModel productModel = productDAO.findByName(name);
        if(productModel == null){
            throw new ProductOrUserNotFoundException();
        }
        logger.info("This is the product returned: {}", productModel);
        return productModel;
    }

    public ProductModel getById(UUID id){
        ProductModel productModel = productDAO.findById(id);
        if(productModel == null){
            throw new ProductIdOrUserIdDoesNotExistsException();
        }
        logger.info("This is the product returned: {}", productModel);
        return productModel;
    }
    public ProductModel updateProduct(String name, Integer price){
        ProductModel productModel = productDAO.findByName(name);
        if(productModel == null){
            throw new ProductOrUserNotFoundException();
        }
        productModel = productDAO.updatePriceByName(name, price);
        logger.info("The update product is: {}", productModel);
        return productModel;
    }

    public void delete(UUID id) {
        if(productDAO.findById(id) == null){
            throw new ProductIdOrUserIdDoesNotExistsException();
        }
        productDAO.deleteProduct(id);
    }
}
