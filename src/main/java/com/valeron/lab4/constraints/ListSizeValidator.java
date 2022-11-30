package com.valeron.lab4.constraints;

import jakarta.validation.*;

import java.util.List;

public final class ListSizeValidator
        implements ConstraintValidator<ListSize, List<?>> {

    private Integer listSize;

    @Override
    public void initialize(ListSize constraintAnnotation) {
        listSize = constraintAnnotation.size();
    }

    @Override
    public boolean isValid(List<?> integers, ConstraintValidatorContext constraintValidatorContext) {

        return integers == null || integers.size() == listSize;

    }
}
