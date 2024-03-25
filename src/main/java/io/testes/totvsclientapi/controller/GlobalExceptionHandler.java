package io.testes.totvsclientapi.controller;

import io.testes.totvsclientapi.controller.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalState(IllegalStateException ex) {
        return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage(), "Formulário Inválido, verifique as informações"));
    }
}
