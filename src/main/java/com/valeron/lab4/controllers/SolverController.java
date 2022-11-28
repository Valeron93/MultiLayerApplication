package com.valeron.lab4.controllers;

import com.valeron.lab4.dao.SimpleRepository;
import com.valeron.lab4.dto.*;
import com.valeron.lab4.model.SolveResult;
import com.valeron.lab4.solver.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SolverController {

    private final EuclidSolver solver;
    private final SimpleRepository<SolveResult> repository;

    @Autowired
    SolverController(EuclidSolver solver, SimpleRepository<SolveResult> repository) {
        this.solver = solver;
        this.repository = repository;
    }

    @PostMapping(value = "/solve", produces = "application/json")
    public ResponseEntity<?> solve(@RequestBody SolveRequest request) {

        if (request.input == null || request.input.size() != 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        final var pair = new IntegerPair(request.input.get(0), request.input.get(1));

        if (pair.first <= 0 || pair.second <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        final var response = request.withSteps
                ? solver.solveWithSteps(pair)
                : solver.solve(pair);

        final var id = repository.save(response);

        return new ResponseEntity<>(new SolveResponse(id), HttpStatus.CREATED);
    }


    @GetMapping(value = "/getSolved/{id}", produces = "application/json")
    public ResponseEntity<?> getSolved(@PathVariable int id) {

        final var result = repository.get(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
