package com.valeron.lab4.model;

import java.io.Serializable;

public sealed abstract class SolveResult implements Serializable permits SolveWithStepsResult, SolveWithoutStepsResult {

    public abstract String serialize();

    public static SolveResult deserialize(String data) {

        String[] split = data.split(",");

        if (split[0].equals("withoutSteps")) {
            return new SolveWithoutStepsResult(Integer.parseInt(split[1]));
        }

        return null;
    }

}
