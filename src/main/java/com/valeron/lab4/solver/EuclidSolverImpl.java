package com.valeron.lab4.solver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class EuclidSolverImpl implements EuclidSolver {
    @Override
    public List<IntegerPair> solveWithSteps(IntegerPair numbers) {
        return List.of(new IntegerPair(0, 0));
    }

    @Override
    public int solve(IntegerPair numbers) {

        int a = numbers.first;
        int b = numbers.second;

        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }

        return a;
    }

}
