package com.java17.springboot3.microservice.restful.controllers;

import com.java17.springboot3.microservice.restful.models.UserModel;
import com.java17.springboot3.microservice.restful.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void createUser() {
        // Configurar datos de prueba
        UserModel userModel = new UserModel();
        userModel.setFirstName("Test User");

        Long expectedUserId = 1L;

        // Configurar mock del servicio
        Mockito.when(userService.createUser(userModel))
                .thenReturn(expectedUserId);

        // Llamar al metodo del controlador
        ResponseEntity<Long> response = userController.createUser(userModel);

        // Verificar el resultado
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedUserId, response.getBody());

        // Verificar la interacción con el servicio
        Mockito.verify(userService, times(1)).createUser(userModel);
    }

    @Test
    void findUserAll() {
        UserModel user1 = new UserModel();
        user1.setId(1L);
        user1.setFirstName("User1");

        UserModel user2 = new UserModel();
        user2.setId(2L);
        user2.setFirstName("User2");

        Mockito.when(userService.findUserAll())
                .thenReturn(Arrays.asList(user1, user2));

        ResponseEntity<List<UserModel>> response = userController.findUserAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(2, response.getBody().size());

        Mockito.verify(userService, times(1)).findUserAll();
    }

    @Test
    void findUserById() {
        UserModel user = new UserModel();
        user.setId(1L);
        user.setFirstName("Test User");

        Mockito.when(userService.findUserById(1L))
                .thenReturn(user);

        ResponseEntity<UserModel> response = userController.findUserById(1L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(1L, response.getBody().getId());

        Mockito.verify(userService, times(1)).findUserById(1L);
    }

    @Test
    void updateUser() {
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setFirstName("Updated User");

        Mockito.doNothing().when(userService).updateUser(1L, userModel);

        ResponseEntity<Void> response = userController.updateUser(1L, userModel);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCodeValue());

        Mockito.verify(userService, times(1)).updateUser(1L, userModel);
    }

    @Test
    void deleteUser() {
        Mockito.doNothing().when(userService).deleteUser(1L);

        ResponseEntity<Void> response = userController.deleteUser(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        Mockito.verify(userService, times(1)).deleteUser(1L);
    }

}