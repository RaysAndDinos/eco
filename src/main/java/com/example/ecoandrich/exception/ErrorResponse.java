package com.example.ecoandrich.exception;

public record ErrorResponse(
        Integer statusCode,
        String message
) {
}
