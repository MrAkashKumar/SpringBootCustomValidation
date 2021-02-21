package com.akash.customValidation.errorHandler;

import lombok.*;

import java.util.List;

@Builder
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {

    private String errorCode;

    private String errorMessage;

    private List<ApiError> apiErrors;
}
