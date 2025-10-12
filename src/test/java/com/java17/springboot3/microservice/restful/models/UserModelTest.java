package com.java17.springboot3.microservice.restful.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Christian Hume (DEV)
 * @version 1.0.0
 * @since 2025-10-01
 */
class UserModelTest {

    @Test
    void testSettersAndGetters() {
        UserModel userModel = new UserModel();

        userModel.setId(1L);
        userModel.setFirstName("John");
        userModel.setLastName("Doe");
        userModel.setNationality("Chilean");
        userModel.setOccupation("Engineer");
        userModel.setKnownFor("Software Development");
        userModel.setPhone("+56 987654321");
        userModel.setEmail("john.doe@example.com");

        Assertions.assertEquals(1L, userModel.getId());
        Assertions.assertEquals("John", userModel.getFirstName());
        Assertions.assertEquals("Doe", userModel.getLastName());
        Assertions.assertEquals("Chilean", userModel.getNationality());
        Assertions.assertEquals("Engineer", userModel.getOccupation());
        Assertions.assertEquals("Software Development", userModel.getKnownFor());
        Assertions.assertEquals("+56 987654321", userModel.getPhone());
        Assertions.assertEquals("john.doe@example.com", userModel.getEmail());
    }

    @Test
    void testDefaultConstructor() {
        UserModel userModel = new UserModel();

        Assertions.assertNull(userModel.getId());
        Assertions.assertNull(userModel.getFirstName());
        Assertions.assertNull(userModel.getLastName());
        Assertions.assertNull(userModel.getNationality());
        Assertions.assertNull(userModel.getOccupation());
        Assertions.assertNull(userModel.getKnownFor());
        Assertions.assertNull(userModel.getPhone());
        Assertions.assertNull(userModel.getEmail());
    }

}