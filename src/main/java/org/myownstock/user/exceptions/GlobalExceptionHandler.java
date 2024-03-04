package org.myownstock.user.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Vous pouvez vérifier les détails de l'exception pour personnaliser le message
        if (ex.getMostSpecificCause().getMessage().contains("Duplicate entry")) {
            return new ResponseEntity<>("Cette adresse e-mail est déjà utilisée.", HttpStatus.CONFLICT);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue.");
    }

    // Ajoutez d'autres gestionnaires d'exceptions si nécessaire
}