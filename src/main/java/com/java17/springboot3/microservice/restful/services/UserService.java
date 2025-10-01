package com.java17.springboot3.microservice.restful.services;

import com.java17.springboot3.microservice.restful.models.UserModel;

import java.util.List;

/**
 * @author Username Developer (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
public interface UserService {

    Long createUser(UserModel userModel);

    List<UserModel> findUserAll();

    UserModel findUserById(Long idUser);

    void updateUser(Long idUser, UserModel userModel);

    void deleteUser(Long idUser);

}
