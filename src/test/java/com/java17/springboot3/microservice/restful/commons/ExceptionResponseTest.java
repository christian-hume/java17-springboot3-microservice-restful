package com.java17.springboot3.microservice.restful.commons;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Username Developer (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
class ExceptionResponseTest {

    @Test
    void testBuilder_CreatesValidObject() {
        LocalDateTime now = LocalDateTime.now();

        ExceptionResponse response = ExceptionResponse.builder()
                .timestamp(now)
                .status(500)
                .error("Internal Server Error")
                .message("Something went wrong")
                .path("/api/test")
                .build();

        assertNotNull(response);
        assertEquals(now, response.getTimestamp());
        assertEquals(500, response.getStatus());
        assertEquals("Internal Server Error", response.getError());
        assertEquals("Something went wrong", response.getMessage());
        assertEquals("/api/test", response.getPath());
    }

    @Test
    void testSettersAndGetters() {
        ExceptionResponse response = ExceptionResponse.builder().build();

        LocalDateTime now = LocalDateTime.now();
        response.setTimestamp(now);
        response.setStatus(400);
        response.setError("Bad Request");
        response.setMessage("Invalid input");
        response.setPath("/api/invalid");

        assertEquals(now, response.getTimestamp());
        assertEquals(400, response.getStatus());
        assertEquals("Bad Request", response.getError());
        assertEquals("Invalid input", response.getMessage());
        assertEquals("/api/invalid", response.getPath());
    }

    @Test
    void getTimestamp() {
    }

    @Test
    void setTimestamp() {
    }

    @Test
    void getStatus() {
    }

    @Test
    void setStatus() {
    }

    @Test
    void getError() {
    }

    @Test
    void setError() {
    }

    @Test
    void getMessage() {
    }

    @Test
    void setMessage() {
    }

    @Test
    void getPath() {
    }

    @Test
    void setPath() {
    }

    @Test
    void builder() {
    }
}