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
    public Long createUser(UserModel userCreate) {
        UserModel userNew = userRepository.save(userCreate);
        return userNew.getId();
    }

    @Override
    public List<UserModel> findUserAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findUserById(Long idUser) {
        UserModel userReturn = null;
        Optional<UserModel> userOptional = userRepository.findById(idUser);
        if (userOptional.isPresent()) {
            userReturn = userOptional.get();
        }
        return userReturn;
    }

    @Override
    public void updateUser(Long idUser, UserModel userUpdate) {
        userRepository.save(userUpdate);
    }

    @Override
    public void deleteUser(Long idUser) {
        Optional<UserModel> userOptional = userRepository.findById(idUser);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        }
    }

}
