package com.example.INGProject.domain;

import com.example.INGProject.dao.UserDAO;
import com.example.INGProject.domain.exception.NoProductsOrUsersExistsException;
import com.example.INGProject.domain.exception.ProductOrUserAlreadyExistsException;
import com.example.INGProject.domain.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public UserModel create(UserModel userModel){
        List<UserModel> list = userDAO.findAll();
        boolean exist = list.stream().anyMatch(elem -> elem.getEmail().equals(userModel.getEmail()));
        if(exist){
            throw new ProductOrUserAlreadyExistsException();
        }
        return userDAO.save(userModel);
    }

    public List<UserModel> getAll(){
        List<UserModel> users = userDAO.findAll();
        if(users.isEmpty()){
            throw new NoProductsOrUsersExistsException();
        }
        return users;
    }
}
