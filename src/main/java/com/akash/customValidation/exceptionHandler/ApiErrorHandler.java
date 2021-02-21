package com.akash.customValidation.exceptionHandler;

import com.akash.customValidation.errorHandler.ApiError;
import com.akash.customValidation.errorHandler.ApiErrorResponse;
import com.akash.customValidation.errorHandler.ApiValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(value = {})
    public ResponseEntity<ApiErrorResponse> handleException(MethodArgumentNotValidException ex){

        List<ApiError> apiValidationErrors = new ArrayList<>();
        Optional<List<FieldError>> fieldErrors = Optional.ofNullable(ex.getBindingResult().getFieldErrors());
        if (fieldErrors.isPresent()) {
            ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
                apiValidationErrors.add(ApiValidationError.builder().field(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        /*.object(fieldError.getObjectName())*/
                       /* .rejectedValue(fieldError.getField())*/
                        .build());
            });
        }
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .errorMessage("Validation Errors")
                .apiErrors(apiValidationErrors)
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
