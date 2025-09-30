package com.java17.springboot3.microservice.restful.controllers;

import com.java17.springboot3.microservice.restful.models.UserModel;
import com.java17.springboot3.microservice.restful.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/java17/springboot3/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Long> createUser(UserModel userModel) {
        return ResponseEntity.ok(userService.createUser(userModel));
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserModel>> findUserAll() {
        return ResponseEntity.ok(userService.findUserAll());
    }

    @GetMapping(value = "/users/{id_user}")
    public ResponseEntity<UserModel> findUserById(@PathVariable Long idUser) {
        return ResponseEntity.ok(userService.findUserById(idUser));
    }

    @PutMapping(value = "/users")
    public ResponseEntity<Void> updateUser(@PathVariable Long idUser, @RequestBody UserModel userModel) {
        userService.updateUser(idUser, userModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/users")
    public ResponseEntity<Void> deleteUser(Long isUser) {
        userService.deleteUser(isUser);
        return ResponseEntity.ok().build();
    }

}
