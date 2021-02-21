package com.akash.customValidation.validations;

import com.akash.customValidation.dto.Employee;
import com.akash.customValidation.validations.constraint.ValidEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

public class EmployeeValidator implements ConstraintValidator<ValidEmployee, Employee> {

    @Autowired
    private Validator validator;

    @Override
    public void initialize(ValidEmployee constraintAnnotation) {

    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext context) {
        boolean isValid = true;
        Set<ConstraintViolation<Employee>> constraintViolations = new HashSet<>();
        constraintViolations =
                validator.validate(employee);
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            context.disableDefaultConstraintViolation();
            for (ConstraintViolation<Employee> violation : constraintViolations) {
                context.buildConstraintViolationWithTemplate(violation.getMessageTemplate())
                        .addConstraintViolation();
            }
            isValid = false;
        }
        return isValid;
    }

}
