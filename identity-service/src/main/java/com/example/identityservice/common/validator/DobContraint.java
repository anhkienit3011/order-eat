package com.example.identityservice.common.validator;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DobValidator.class})
public @interface DobContraint {
    String message() default "Invalid date of birth ";

    int min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
