package com.valeron.lab4.solver;

import com.valeron.lab4.model.CalculationResult;

public interface EuclidSolver {

    CalculationResult solveWithSteps(IntegerPair input);
    CalculationResult solve(IntegerPair input);

}
