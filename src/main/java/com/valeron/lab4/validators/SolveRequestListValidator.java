package com.valeron.lab4.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public final class SolveRequestListValidator
        implements ConstraintValidator<SolveRequestList, List<Integer>> {
    @Override
    public boolean isValid(List<Integer> integers, ConstraintValidatorContext constraintValidatorContext) {

        return integers != null && integers.size() == 2 && integers.stream().allMatch(x -> x > 0) ;

    }
}
