package com.valeron.lab4.constraints;

import jakarta.validation.*;

import java.util.List;

public final class ListMinValueValidator implements ConstraintValidator<ListMinValue, List<Integer>> {

    private int min;

    @Override
    public void initialize(ListMinValue constraintAnnotation) {
        min = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(List<Integer> integerList, ConstraintValidatorContext constraintValidatorContext) {

        return integerList == null || integerList.stream().allMatch(x -> x >= min);
    }
}
