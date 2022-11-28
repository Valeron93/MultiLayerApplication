package com.valeron.lab4.solver;

import java.util.List;

public record IntegerPair(int first, int second) {

    public int first() {
        return first;
    }

    public int second() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }

    public List<Integer> toList() {
        return List.of(first, second);
    }
}
