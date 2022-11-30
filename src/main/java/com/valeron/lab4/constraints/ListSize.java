package com.valeron.lab4.constraints;


import jakarta.validation.*;
import java.lang.annotation.*;

@Constraint(validatedBy = ListSizeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListSize {
    String message() default "Invalid list size";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int size();

}
