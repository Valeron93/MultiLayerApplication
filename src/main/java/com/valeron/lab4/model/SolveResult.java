package com.valeron.lab4.model;


import com.valeron.lab4.solver.IntegerPair;

import java.util.ArrayList;
import java.util.List;

public sealed abstract class SolveResult permits SolveWithStepsResult, SolveSimpleResult {

    public final List<Integer> input;


    public SolveResult(IntegerPair pair) {
        input = pair.toList();
    }

    public abstract String serialize();

    public static SolveResult deserialize(String data) {

        final String[] split = data.split(",");

        if (split.length < 3) {
            throw new RuntimeException("Failed to deserialize '" + data + "'");
        }

        final var input = new IntegerPair(
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2])
        );

        final var result = Integer.parseInt(split[3]);

        if (split[0].equals("simple")) {
            return new SolveSimpleResult(input, result);
        }

        else if (split[0].equals("withSteps")) {
            final List<IntegerPair> steps = new ArrayList<>();

            for (int i = 4; i < split.length; i += 2) {

                final var a = Integer.parseInt(split[i]);
                final var b = Integer.parseInt(split[i+1]);

                steps.add(new IntegerPair(a, b));
            }

            return new SolveWithStepsResult(input, result, steps);
        }

        return null;
    }

}
