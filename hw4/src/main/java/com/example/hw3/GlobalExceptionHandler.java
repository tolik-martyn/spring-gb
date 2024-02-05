package com.example.hw3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

/**
 * Глобальный обработчик исключений для обработки исключений типа ResponseStatusException.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обрабатывает исключение типа ResponseStatusException.
     *
     * @param ex Исключение ResponseStatusException.
     * @return Ответ с кодом состояния и причиной исключения.
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getReason(), ex.getStatusCode());
    }
}