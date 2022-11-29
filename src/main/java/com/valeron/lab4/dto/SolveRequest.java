package com.valeron.lab4.dto;


import java.util.Collections;
import java.util.List;

public record SolveRequest(List<Integer> input, boolean withSteps) {

    public List<Integer> getInput() {
        return Collections.unmodifiableList(input);
    }

    public boolean getWithSteps() {
        return withSteps;
    }

}
