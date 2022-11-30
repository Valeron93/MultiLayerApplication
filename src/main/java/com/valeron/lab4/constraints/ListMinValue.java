package com.valeron.lab4.constraints;

import jakarta.validation.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListMinValueValidator.class)
public @interface ListMinValue {
    String message() default "Invalid list values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int value();
}
