package com.akash.customValidation.errorHandler;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
public class ApiValidationError extends ApiError{

    private String message;
    private String field;
    /*private String object;
    private Object rejectedValue;*/

}
