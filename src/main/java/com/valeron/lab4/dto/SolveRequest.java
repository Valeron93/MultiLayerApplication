package com.valeron.lab4.dto;

import com.valeron.lab4.constraints.*;

import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SolveRequest {

    @ListSize(size = 2, message = "Input size has to be 2")
    @ListMinValue(value = 1, message = "Input numbers has to be greater than zero")
    @NotNull(message = "Input cannot be null")
    private final List<Integer> input;

    @NotNull
    private final Boolean withSteps;

    public SolveRequest(List<Integer> input, boolean withSteps) {
        this.input = input;
        this.withSteps = withSteps;
    }

    public List<Integer> getInput() {
        return Collections.unmodifiableList(input);
    }

    public Boolean getWithSteps() {
        return withSteps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolveRequest that = (SolveRequest) o;
        return Objects.equals(withSteps, that.withSteps) && Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, withSteps);
    }
}
