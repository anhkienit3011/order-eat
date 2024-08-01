package com.example.identityservice.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {DobValidator.class}
)
public @interface  DobContraint {
    String message() default "Invalid date of birth ";

    int min();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
