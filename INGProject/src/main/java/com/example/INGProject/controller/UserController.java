package com.example.INGProject.controller;


import com.example.INGProject.controller.dto.CreateUserReqDTO;
import com.example.INGProject.controller.dto.CreateUserResDTO;
import com.example.INGProject.domain.UserService;
import com.example.INGProject.domain.model.UserModel;
import com.example.INGProject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<CreateUserResDTO> createProduct(@RequestBody CreateUserReqDTO createUserReqDTO){
        UserModel userModel = userMapper.createUserReqDTOToUserModel(createUserReqDTO);
        UserModel createUser = userService.create(userModel);
        return ResponseEntity.ok(userMapper.userModelToCreateUserResDTO(createUser));
    }


    @PostMapping("/login/{username}/{password}")
    public ResponseEntity<String> login(@PathVariable String username, @PathVariable String password){
        List<UserModel> userModels = userService.getAll();
        boolean userValid = userModels.stream().anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
        if(userValid){
            return ResponseEntity.ok("Login Successfull");
        }else{
            return ResponseEntity.status(401).body("Username or password invalid!");
        }
    }

}
