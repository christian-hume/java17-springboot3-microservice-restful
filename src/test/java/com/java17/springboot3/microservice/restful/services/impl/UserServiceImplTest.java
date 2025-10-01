package com.java17.springboot3.microservice.restful.services.impl;

import com.java17.springboot3.microservice.restful.models.UserModel;
import com.java17.springboot3.microservice.restful.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

/**
 * @author Username Developer (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        // MockitoAnnotations.openMocks(this);
    }


    @Test
    void createUser() {
        UserModel userCreate = new UserModel();
        userCreate.setFirstName("Test User");

        UserModel userSaved = new UserModel();
        userSaved.setId(1L);
        userSaved.setFirstName("Test User");

        Mockito.when(userRepository.save(userCreate))
                .thenReturn(userSaved);

        Long userId = userService.createUser(userCreate);

        Assertions.assertEquals(1L, userId);

        Mockito.verify(userRepository, times(1)).save(userCreate);
    }

    @Test
    void findUserAll() {
        UserModel user1 = new UserModel();
        user1.setId(1L);
        user1.setFirstName("User1");

        UserModel user2 = new UserModel();
        user2.setId(2L);
        user2.setFirstName("User2");

        Mockito.when(userRepository.findAll())
                .thenReturn(Arrays.asList(user1, user2));

        List<UserModel> result = userService.findUserAll();

        Assertions.assertNotNull(result);

        Mockito.verify(userRepository, times(1)).findAll();
    }

   @Test
    void findUserById() {
       UserModel user = new UserModel();
       user.setId(1L);
       user.setFirstName("Test User");

       Mockito.when(userRepository.findById(1L))
               .thenReturn(Optional.of(user));

       UserModel result = userService.findUserById(1L);

       Assertions.assertNotNull(result);
       Assertions.assertEquals(1L, result.getId());

       Mockito.verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void updateUser() {
        UserModel userUpdate = new UserModel();
        userUpdate.setId(1L);
        userUpdate.setFirstName("Updated User");

        userService.updateUser(1L, userUpdate);

        Mockito.verify(userRepository, times(1)).save(userUpdate);
    }

    @Test
    void deleteUser() {
        UserModel user = new UserModel();
        user.setId(1L);
        user.setFirstName("Test User");

        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        userService.deleteUser(1L);

        Mockito.verify(userRepository, times(1)).findById(1L);
        Mockito.verify(userRepository, times(1)).delete(user);
    }

}