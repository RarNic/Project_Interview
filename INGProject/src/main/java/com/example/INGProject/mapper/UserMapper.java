package com.example.INGProject.mapper;

import com.example.INGProject.controller.dto.CreateUserReqDTO;
import com.example.INGProject.controller.dto.CreateUserResDTO;
import com.example.INGProject.domain.model.UserModel;
import com.example.INGProject.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    UserModel userModelToCreateUserReqDTO(CreateUserReqDTO createUserReqDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    CreateUserResDTO userResDTOToUserModel(UserModel userModel);

    UserModel createUserReqDTOToUserModel(CreateUserReqDTO createUserReqDTO);

    UserEntity userModelToUserEntity(UserModel userModel);

    UserModel userEntityToUserModel(UserEntity userEntity);

    CreateUserResDTO userModelToCreateUserResDTO(UserModel userModel);
}
