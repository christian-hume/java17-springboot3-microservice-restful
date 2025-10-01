package com.java17.springboot3.microservice.restful.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Username Developer (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
class UserModelTest {

    @Test
    void testSettersAndGetters() {
        UserModel user = new UserModel();

        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setNationality("Chilean");
        user.setOccupation("Engineer");
        user.setKnownFor("Software Development");
        user.setPhone("+56 987654321");
        user.setEmail("john.doe@example.com");

        assertEquals(1L, user.getId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("Chilean", user.getNationality());
        assertEquals("Engineer", user.getOccupation());
        assertEquals("Software Development", user.getKnownFor());
        assertEquals("+56 987654321", user.getPhone());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    void testDefaultConstructor() {
        UserModel user = new UserModel();

        assertNull(user.getId());
        assertNull(user.getFirstName());
        assertNull(user.getLastName());
        assertNull(user.getNationality());
        assertNull(user.getOccupation());
        assertNull(user.getKnownFor());
        assertNull(user.getPhone());
        assertNull(user.getEmail());
    }

}