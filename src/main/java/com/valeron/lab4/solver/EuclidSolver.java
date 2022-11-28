package com.valeron.lab4.solver;

import com.valeron.lab4.model.SolveWithStepsResult;
import com.valeron.lab4.model.SolveSimpleResult;

public interface EuclidSolver {

    SolveWithStepsResult solveWithSteps(IntegerPair input);
    SolveSimpleResult solve(IntegerPair input);

}
