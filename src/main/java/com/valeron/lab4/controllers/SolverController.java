package com.valeron.lab4.controllers;

import com.valeron.lab4.dao.SimpleRepository;
import com.valeron.lab4.dto.*;
import com.valeron.lab4.model.CalculationResult;
import com.valeron.lab4.solver.*;

import jakarta.validation.*;
import jakarta.validation.constraints.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

@Validated
@RestController
public class SolverController {

    private final EuclidSolver solver;
    private final SimpleRepository<CalculationResult> repository;

    @Autowired
    SolverController(EuclidSolver solver, SimpleRepository<CalculationResult> repository) {
        this.solver = solver;
        this.repository = repository;
    }

    @PostMapping(value = "/solve", produces = "application/json")
    public ResponseEntity<?> solve(@RequestBody @Valid SolveRequest request) {

        final var input = request.getInput();
        final var pair = new IntegerPair(input.get(0), input.get(1));

        final CalculationResult response = request.getWithSteps()
                ? solver.solveWithSteps(pair)
                : solver.solve(pair);

        final var id = repository.save(response);

        return ResponseEntity
                .created(URI.create("/getSolved/" + id))
                .body(response);
    }

    @GetMapping(value = "/getSolved/{id}", produces = "application/json")
    public ResponseEntity<?> getSolved(
            @PathVariable
            @Min(value = 0, message = "Id has to be greater or equal 0")
            Integer id
    ) {

        final var result = repository.get(id);

        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        }

        return ResponseEntity.notFound().build();

    }

}
