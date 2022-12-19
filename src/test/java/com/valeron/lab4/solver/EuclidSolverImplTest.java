package com.valeron.lab4.solver;

import com.valeron.lab4.model.CalculationResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EuclidSolverImplTest {

    private final EuclidSolverImpl solver = new EuclidSolverImpl();

    @Test
    public void solveSimple() {

        final var result = solver.solve(new IntegerPair(1, 1));

        assertEquals("simple", result.getType());
        assertEquals(1, result.getResult());
        assertNull(result.getSteps());
    }

    @Test
    public void solveWithStepsSimple() {
        final var result = solver.solveWithSteps(new IntegerPair(1, 1));

        assertEquals("withSteps", result.getType());
        assertEquals(1, result.getResult());

        List<List<Integer>> steps = List.of(
                List.of(1, 1)
        );

        assertEquals(steps, result.getSteps());
    }

    @Test
    public void solvesGcdCorrectly() {
        CalculationResult result;

        result = solver.solve(new IntegerPair(770, 900));
        assertEquals(10, result.getResult());

        result = solver.solve(new IntegerPair(100, 50));
        assertEquals(50, result.getResult());
    }

    @Test
    public void throwsIfWrongInput() {
        final var wrongInput = new IntegerPair(-1, 0);

        assertThrows(ArithmeticException.class, () -> solver.solve(wrongInput));
        assertThrows(ArithmeticException.class, () -> solver.solveWithSteps(wrongInput));
    }

}