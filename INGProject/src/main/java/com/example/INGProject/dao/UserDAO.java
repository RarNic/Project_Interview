package com.example.INGProject.dao;

import com.example.INGProject.domain.model.ProductModel;
import com.example.INGProject.domain.model.UserModel;
import com.example.INGProject.mapper.UserMapper;
import com.example.INGProject.repository.UserRepository;
import com.example.INGProject.repository.entity.ProductEntity;
import com.example.INGProject.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel userModel){
        UserEntity userEntity = userMapper.userModelToUserEntity(userModel);
        UserEntity createUserEntity = userRepository.save(userEntity);
        return userMapper.userEntityToUserModel(createUserEntity);
    }

    public UserModel findById(Integer id){
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(entity -> userMapper.userEntityToUserModel(entity)).orElse(null);
    }

    public List<UserModel> findAll(){
        List<UserEntity> listEntities = userRepository.findAll();
        List<UserModel> products = new ArrayList<>();
        listEntities.forEach(entity -> products.add(userMapper.userEntityToUserModel(entity)));
        return products;
    }
}
