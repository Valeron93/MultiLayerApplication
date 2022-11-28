package com.valeron.lab4.solver;

import com.valeron.lab4.model.SolveWithStepsResult;
import com.valeron.lab4.model.SolveSimpleResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class EuclidSolverImpl implements EuclidSolver {
    @Override
    public SolveWithStepsResult solveWithSteps(IntegerPair input) {
        final List<IntegerPair> steps = new ArrayList<>();

        int a = input.first;
        int b = input.second;

        steps.add(new IntegerPair(a, b));

        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
            steps.add(new IntegerPair(a, b));
        }

        final var result = a;

        return new SolveWithStepsResult(input, result, steps);
    }

    @Override
    public SolveSimpleResult solve(IntegerPair input) {

        int a = input.first;
        int b = input.second;

        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }

        final var result = a;

        return new SolveSimpleResult(input, result);
    }

}
