package com.valeron.lab4.model;

import com.valeron.lab4.solver.IntegerPair;

import java.util.ArrayList;
import java.util.List;

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
}
