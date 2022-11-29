package com.valeron.lab4.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = SolveRequestListValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface SolveRequestList {
    String message() default "Invalid input numbers";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
