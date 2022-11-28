package com.valeron.lab4.mocks;


import com.valeron.lab4.dao.SimpleRepository;
import com.valeron.lab4.model.SolveResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockRepository implements SimpleRepository<SolveResult> {

    private final List<SolveResult> list = new ArrayList<>();

    @Override
    public int put(SolveResult element) {
        System.out.println("added to test rep");

        int i = list.size();
        list.add(element);
        return i;

    }

    @Override
    public Optional<SolveResult> get(int id) {
        if (id < list.size()) {
            return Optional.of(list.get(id));
        }

        return Optional.empty();
    }


}
