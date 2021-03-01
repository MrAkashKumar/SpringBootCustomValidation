package com.akash.customValidation.dto;

import com.akash.customValidation.validations.constraint.NumericValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Employee {

    @NotBlank
    private String employeeName;

    @NumericValue(message = "employeeMobile should be numeric")
    private String employeeMobile;

    @NumericValue(message = "employeeCode should be numeric")
    private String employeeCode;


}
