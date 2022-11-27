package com.valeron.lab4.controllers;

import com.valeron.lab4.dao.SimpleRepository;
import com.valeron.lab4.dto.*;
import com.valeron.lab4.model.SolveWithStepsResult;
import com.valeron.lab4.model.SolveWithoutStepsResult;
import com.valeron.lab4.solver.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SolverController {

    private final EuclidSolver solver;
    private final SimpleRepository repository;

    @Autowired
    SolverController(EuclidSolver solver, SimpleRepository repository) {
        this.solver = solver;
        this.repository = repository;

    }

    @PostMapping(value = "/solve", produces = "application/json")
    public ResponseEntity<?> solve(@RequestBody SolveRequest request) {

        final var pair = new IntegerPair(request.numbers.get(0), request.numbers.get(1));

        if (pair.first <= 0 && pair.second <= 0) {
            return new ResponseEntity<>("Invalid numbers", HttpStatus.BAD_REQUEST);
        }

        if (pair.first <= 0) {
            return new ResponseEntity<>("First number is invalid", HttpStatus.BAD_REQUEST);
        }

        if (pair.second <= 0) {
            return new ResponseEntity<>("Second number is invalid", HttpStatus.BAD_REQUEST);
        }

        var response = request.withSteps
                ? new SolveWithStepsResult(solver.solveWithSteps(pair))
                : new SolveWithoutStepsResult(solver.solve(pair));

        var id = repository.put(response);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }


    @GetMapping(value = "/getSolved/{id}", produces = "application/json")
    public ResponseEntity<?> getSolved(@PathVariable int id) {

        var result = repository.get(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

}
