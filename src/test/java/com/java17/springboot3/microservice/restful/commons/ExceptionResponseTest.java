package com.java17.springboot3.microservice.restful.commons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * @author Christian Hume (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
class ExceptionResponseTest {

    @Test
    void testBuilder_CreatesValidObject() {
        LocalDateTime now = LocalDateTime.now();

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(now)
                .status(500)
                .error("Internal Server Error")
                .message("Something went wrong")
                .path("/api/test")
                .build();

        Assertions.assertNotNull(exceptionResponse);
        Assertions.assertEquals(now, exceptionResponse.getTimestamp());
        Assertions.assertEquals(500, exceptionResponse.getStatus());
        Assertions.assertEquals("Internal Server Error", exceptionResponse.getError());
        Assertions.assertEquals("Something went wrong", exceptionResponse.getMessage());
        Assertions.assertEquals("/api/test", exceptionResponse.getPath());
    }

    @Test
    void testSettersAndGetters() {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().build();

        LocalDateTime now = LocalDateTime.now();
        exceptionResponse.setTimestamp(now);
        exceptionResponse.setStatus(400);
        exceptionResponse.setError("Bad Request");
        exceptionResponse.setMessage("Invalid input");
        exceptionResponse.setPath("/api/invalid");

        Assertions.assertEquals(now, exceptionResponse.getTimestamp());
        Assertions.assertEquals(400, exceptionResponse.getStatus());
        Assertions.assertEquals("Bad Request", exceptionResponse.getError());
        Assertions.assertEquals("Invalid input", exceptionResponse.getMessage());
        Assertions.assertEquals("/api/invalid", exceptionResponse.getPath());
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