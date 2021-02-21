package com.akash.customValidation.validations.constraint;

import com.akash.customValidation.validations.NumericValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {NumericValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NumericValue {

    String message() default "String should be numeric";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
