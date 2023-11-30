package com.example.INGProject.domain;

import com.example.INGProject.dao.ProductDAO;
import com.example.INGProject.domain.exception.NoProductsExistsException;
import com.example.INGProject.domain.exception.ProductAlreadyExistsException;
import com.example.INGProject.domain.exception.ProductNotFoundException;
import com.example.INGProject.domain.exception.ProductIdDoesNotExistsException;
import com.example.INGProject.domain.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public ProductModel create(ProductModel productModel){
        List<ProductModel> list = productDAO.findAll();
        boolean exist = list.stream().anyMatch(elem -> elem.getName().equals(productModel.getName()));
        if(exist){
            throw new ProductAlreadyExistsException();
        }
        return productDAO.save(productModel);
    }

    public List<ProductModel> getAll(){
        List<ProductModel> products = productDAO.findAll();
        if(products.isEmpty()){
            throw new NoProductsExistsException();
        }
        return products;
    }

    public ProductModel getByName(String name){
        ProductModel productModel = productDAO.findByName(name);
        if(productModel == null){
            throw new ProductNotFoundException();
        }
        return productModel;
    }

    public ProductModel getById(UUID id){
        ProductModel productModel = productDAO.findById(id);
        if(productModel == null){
            throw new ProductIdDoesNotExistsException();
        }
        return productModel;
    }
    public ProductModel updateProduct(String name, Integer price){
        ProductModel productModel = productDAO.findByName(name);
        if(productModel == null){
            throw new ProductNotFoundException();
        }
        productModel = productDAO.updatePriceByName(name, price);
        return productModel;
    }

    public void delete(UUID id) {
        if(productDAO.findById(id) == null){
            throw new ProductIdDoesNotExistsException();
        }
        productDAO.deleteProduct(id);
    }
}
