package com.akash.customValidation.validations.constraint;


import com.akash.customValidation.validations.EmployeeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeValidator.class})
@Documented
public @interface ValidEmployee {

    String message() default "Invalid customer location";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
