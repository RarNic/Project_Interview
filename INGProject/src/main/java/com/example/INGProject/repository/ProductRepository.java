package com.example.INGProject.repository;

import com.example.INGProject.repository.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    Optional<ProductEntity> findByName(String name);

    List<ProductEntity> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = :Price WHERE p.name = :name")
    Integer updatePriceByName(String name, Integer price);

    @Transactional
    void deleteByName(String name);
}
