package com.java17.springboot3.microservice.restful.commons;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author Username Developer (DEVs)
 * @version 1.0.0
 * @since 2025-10-01
 */
class ExceptionHandlingTest {

    // @BeforeEach
    // void setUp() {
    // }

    @AfterEach
    void tearDown() {
    }

    @Test
    void handleException() {
    }

    private ExceptionHandling exceptionHandling;

    @Mock
    private WebRequest webRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        exceptionHandling = new ExceptionHandling();
    }

    @Test
    void testHandleException_ReturnsInternalServerError() {
        // Arrange
        Exception exception = new Exception("Test exception");
        when(webRequest.getDescription(false)).thenReturn("uri=/test");

        // Act
        ResponseEntity<ExceptionResponse> response = exceptionHandling.handleException(exception, webRequest);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        ExceptionResponse body = response.getBody();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), body.getStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), body.getError());
        assertEquals("Test exception", body.getMessage());
        assertEquals("uri=/test", body.getPath());
        // timestamp no se valida exacto, pero sí que no es null
        assertEquals(true, body.getTimestamp() != null);
    }
}