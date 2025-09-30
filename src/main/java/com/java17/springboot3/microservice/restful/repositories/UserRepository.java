package com.java17.springboot3.microservice.restful.repositories;

import com.java17.springboot3.microservice.restful.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
