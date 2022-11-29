package com.valeron.lab4;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.valeron.lab4.controllers.SolverController;
import com.valeron.lab4.dto.SolveRequest;
import com.valeron.lab4.model.SolveSimpleResult;
import com.valeron.lab4.solver.IntegerPair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(SolverController.class)
class SolverControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void submitSimpleRequest() {

        var request = new SolveRequest(List.of(1, 1), false);
        var expected = new SolveSimpleResult(new IntegerPair(1, 1), 1);



    }

}
