package com.valeron.lab4.model;

import com.valeron.lab4.solver.IntegerPair;

import java.util.List;

public final class SolveWithStepsResult extends SolveResult {

    public List<IntegerPair> result;

    public SolveWithStepsResult(List<IntegerPair> integerPairs) {
        result = integerPairs;
    }

    @Override
    public String toString() {
        return "SolveWithStepsResult{" +
                "result=" + result +
                '}';
    }

    @Override
    public String serialize() {
        return "withSteps";
    }
}
