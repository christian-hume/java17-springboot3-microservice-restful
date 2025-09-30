package com.java17.springboot3.microservice.restful.services;

import com.java17.springboot3.microservice.restful.models.UserModel;

import java.util.List;

public interface UserService {

    Long createUser(UserModel userModel);

    List<UserModel> findUserAll();

    UserModel findUserById(Long idUser);

    void updateUser(Long idUser, UserModel userModel);

    void deleteUser(Long idUser);

}
