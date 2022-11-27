package com.valeron.lab4.dao;

import com.valeron.lab4.model.SolveResult;

import java.util.Optional;

public interface SimpleRepository {

    int put(SolveResult element);
    Optional<SolveResult> get(int id);

}
