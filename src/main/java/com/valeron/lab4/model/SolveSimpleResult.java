package com.valeron.lab4.model;


import com.valeron.lab4.solver.IntegerPair;

import java.util.Objects;

public final class SolveSimpleResult extends SolveResult {

    public int result;

    public SolveSimpleResult(IntegerPair input, int result) {
        super(input);
        this.result = result;
    }

    @Override
    public String serialize() {
        return String.join(",", "simple", input.get(0).toString(), input.get(1).toString(), Integer.toString(result));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SolveSimpleResult that = (SolveSimpleResult) o;
        return result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), result);
    }
}
