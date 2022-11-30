package com.valeron.lab4.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

public class CalculationResult {

    private Integer id;

    private List<Integer> input;
    private Integer result;
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<List<Integer>> steps;


    public CalculationResult id(Integer id) {
        this.id = id;

        return this;
    }

    public Integer getId() {
        return id;
    }

    public CalculationResult type(String type) {
        this.type = type;

        return this;
    }

    public String getType() {
        return type;
    }

    public CalculationResult input(List<Integer> input) {
        this.input = input;

        return this;
    }

    public List<Integer> getInput() {

        return input;
    }


    public CalculationResult steps(List<List<Integer>> steps) {

        this.steps = steps;

        return this;
    }

    public List<List<Integer>> getSteps() {

        return steps;
    }

    public CalculationResult result(int result) {
        this.result = result;

        return this;
    }

    public Integer getResult() {
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResult that = (CalculationResult) o;
        return Objects.equals(id, that.id)
                && Objects.equals(type, that.type)
                && Objects.equals(steps, that.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, steps);
    }
}
