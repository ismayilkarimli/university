package com.university.controller.exceptionhandler;

import com.university.error.ApiError;
import com.university.exception.IllegalIdException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorTitle = "Validation error";
        Map<String, String> causes = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> causes.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(errorTitle, causes));
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorTitle = "Path variable error";
        Map<String, String> causes = Map.of("cause", "Missing required path variable " + ex.getParameter());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(errorTitle, causes));
    }

    @ExceptionHandler({IllegalIdException.class})
    public ResponseEntity<ApiError> handleIdException(IllegalIdException ex) {
        String errorTitle = "Id error";
        Map<String, String> causes = Map.of("cause", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(errorTitle, causes));
    }

}
