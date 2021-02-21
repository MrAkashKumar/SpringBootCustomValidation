package com.akash.customValidation.validations;

import com.akash.customValidation.validations.constraint.NumericValue;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;

public class NumericValidator implements ConstraintValidator<NumericValue, String> {

    @Autowired
    private Validator validator;

    @Override
    public void initialize(NumericValue constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.matches("[0-9]+")) return true;
        return false;
    }
}
