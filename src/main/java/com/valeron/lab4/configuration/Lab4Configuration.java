package com.valeron.lab4.configuration;

import com.valeron.lab4.dao.*;
import com.valeron.lab4.model.*;
import com.valeron.lab4.solver.*;
import org.springframework.context.annotation.*;

@Configuration
public class Lab4Configuration {

    @Bean
    @Scope("singleton")
    public SimpleRepository<CalculationResult> solveResultRepository() {
        return new CalculationResultFileStorage();
    }

    @Bean
    @Scope("singleton")
    public EuclidSolver euclidSolver() {
        return new EuclidSolverImpl();
    }

}
