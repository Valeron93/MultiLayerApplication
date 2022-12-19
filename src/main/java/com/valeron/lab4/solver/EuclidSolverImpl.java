package com.valeron.lab4.solver;

import com.valeron.lab4.model.CalculationResult;

import java.util.ArrayList;
import java.util.List;

public final class EuclidSolverImpl implements EuclidSolver {
    @Override
    public CalculationResult solveWithSteps(IntegerPair input) {

        final List<List<Integer>> steps = new ArrayList<>();

        int a = input.first();
        int b = input.second();

        if (a <= 0 || b <= 0) {
            throw new ArithmeticException();
        }

        steps.add(List.of(a, b));

        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
            steps.add(List.of(a, b));
        }

        final var result = a;

        return new CalculationResult()
                .type("withSteps")
                .input(input.toList())
                .result(result)
                .steps(steps);
    }

    @Override
    public CalculationResult solve(IntegerPair input) {

        int a = input.first();
        int b = input.second();

        if (a <= 0 || b <= 0) {
            throw new ArithmeticException();
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }

        final var result = a;

        return new CalculationResult()
                .type("simple")
                .input(input.toList())
                .result(result);
    }

}
