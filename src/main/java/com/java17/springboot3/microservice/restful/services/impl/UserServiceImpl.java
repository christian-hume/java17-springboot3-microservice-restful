package com.java17.springboot3.microservice.restful.services.impl;

import com.java17.springboot3.microservice.restful.models.UserModel;
import com.java17.springboot3.microservice.restful.repositories.UserRepository;
import com.java17.springboot3.microservice.restful.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long createUser(UserModel userModel) {
        return userRepository.createUser(userModel);
    }

    @Override
    public List<UserModel> findUserAll() {
        return userRepository.findUserAll();
    }

    @Override
    public UserModel findUserById(Long idUser) {
        UserModel userModel = null;
        Optional<UserModel> userOptional = userRepository.findUserById(idUser);
        if (userOptional.isPresent()) {
            userModel = userOptional.get();
        }
        return userModel;
    }

    @Override
    public void updateUser(Long idUser, UserModel userModel) {
        userRepository.updateUser(idUser, userModel);
    }

    @Override
    public void deleteUser(Long idUser) {
        userRepository.deleteUser(idUser);
    }

}
