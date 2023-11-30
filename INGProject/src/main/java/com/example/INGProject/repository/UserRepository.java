package com.example.INGProject.repository;

import com.example.INGProject.repository.entity.UserEntity;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public List<UserEntity> findAll();

    public Optional<UserEntity> findById();

}
