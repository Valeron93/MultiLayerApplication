package com.valeron.lab4.model;


import com.valeron.lab4.solver.IntegerPair;

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
}
