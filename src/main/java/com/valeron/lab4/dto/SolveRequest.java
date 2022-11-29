package com.valeron.lab4.dto;

import javax.validation.constraints.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SolveRequest {

    @NotNull
    private final List<Integer> input;

    public final boolean withSteps;

    public SolveRequest(List<Integer> input, boolean withSteps) {
        this.input = input;
        this.withSteps = withSteps;
    }

    public List<Integer> getInput() {
        return Collections.unmodifiableList(input);
    }

    public boolean getWithSteps() {
        return withSteps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolveRequest that = (SolveRequest) o;
        return withSteps == that.withSteps && Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, withSteps);
    }
}
