package com.test.sectionA.q3;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // @Valid triggers the validation rules declared on StudentDTO.
    // On success -> 201 Created. On validation failure the handler below -> 400.
    @PostMapping
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentDTO dto) {
        // ...persist the student here...
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Student created: " + dto.getName());
    }

    // Converts validation failures into a 400 Bad Request with a readable message.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
