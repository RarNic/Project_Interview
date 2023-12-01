package com.example.INGProject;

import com.example.INGProject.dao.ProductDAO;
import com.example.INGProject.domain.ProductService;
import com.example.INGProject.domain.exception.*;
import com.example.INGProject.domain.model.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    @Mock
    private ProductDAO productDAO;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct_Success() {
        ProductModel productModel = new ProductModel();
        productModel.setName("TestProduct");
        when(productDAO.findAll()).thenReturn(Collections.emptyList());
        when(productDAO.save(any(ProductModel.class))).thenReturn(productModel);

        ProductModel createdProduct = productService.create(productModel);

        assertNotNull(createdProduct);
        assertEquals("TestProduct", createdProduct.getName());
        verify(productDAO, times(1)).findAll();
        verify(productDAO, times(1)).save(productModel);
    }

    @Test
    void testCreateProduct_ProductAlreadyExists() {
        ProductModel productModel = new ProductModel();
        productModel.setName("ExistingProduct");
        when(productDAO.findAll()).thenReturn(Collections.singletonList(productModel));

        assertThrows(ProductOrUserAlreadyExistsException.class, () -> productService.create(productModel));

        verify(productDAO, times(1)).findAll();
        verify(productDAO, never()).save(any(ProductModel.class));
    }

    // Adaugă alte teste pentru metodele din ProductService

    // ...

    @Test
    void testDeleteProduct_Success() {
        UUID productId = UUID.randomUUID();
        when(productDAO.findById(productId)).thenReturn(new ProductModel());
        doNothing().when(productDAO).deleteProduct(productId);

        assertDoesNotThrow(() -> productService.delete(productId));

        verify(productDAO, times(1)).findById(productId);
        verify(productDAO, times(1)).deleteProduct(productId);
    }

    @Test
    void testDeleteProduct_ProductIdDoesNotExists() {
        UUID productId = UUID.randomUUID();
        when(productDAO.findById(productId)).thenReturn(null);

        assertThrows(ProductIdOrUserIdDoesNotExistsException.class, () -> productService.delete(productId));

        verify(productDAO, times(1)).findById(productId);
        verify(productDAO, never()).deleteProduct(any(UUID.class));
    }
}
