package com.valeron.lab4.model;

import com.valeron.lab4.solver.IntegerPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class SolveWithStepsResult extends SolveResult {

    public List<List<Integer>> steps;
    public int result;

    public SolveWithStepsResult(IntegerPair input, int result, List<IntegerPair> steps) {
        super(input);

        this.steps = steps.stream().map(IntegerPair::toList).toList();
        this.result = result;
    }

    @Override
    public String toString() {
        return "SolveWithStepsResult{" +
                "result=" + steps +
                '}';
    }

    @Override
    public String serialize() {

        List<String> csv = new ArrayList<>();

        csv.add("withSteps");
        csv.add(input.get(0).toString());
        csv.add(input.get(1).toString());
        csv.add(Integer.toString(result));

        for (var step : steps) {
            csv.add(step.get(0) + "," + step.get(1));
        }

        return String.join(",", csv);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SolveWithStepsResult that = (SolveWithStepsResult) o;
        return result == that.result && Objects.equals(steps, that.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), steps, result);
    }
}
