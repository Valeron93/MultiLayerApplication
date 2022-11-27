package com.valeron.lab4.model;


public final class SolveWithoutStepsResult extends SolveResult {

    public int result;

    public SolveWithoutStepsResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SolveWithoutStepsResult{" +
                "result=" + result +
                '}';
    }

    @Override
    public String serialize() {
        return "withoutSteps," + result;
    }
}
