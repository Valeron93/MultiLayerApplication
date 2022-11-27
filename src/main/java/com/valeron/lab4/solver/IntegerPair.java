package com.valeron.lab4.solver;

import java.io.Serializable;

public final class IntegerPair implements Serializable {

    public final int first;
    public final int second;

    public IntegerPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }
}
