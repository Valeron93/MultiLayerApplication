package com.valeron.lab4.solver;

import java.util.List;

public interface EuclidSolver {

    List<IntegerPair> solveWithSteps(IntegerPair numbers);
    int solve(IntegerPair numbers);

}
