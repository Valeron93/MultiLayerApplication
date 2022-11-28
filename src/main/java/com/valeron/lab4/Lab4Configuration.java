package com.valeron.lab4;

import com.valeron.lab4.dao.*;
import com.valeron.lab4.model.*;
import com.valeron.lab4.solver.*;
import org.springframework.context.annotation.*;

@Configuration
public class Lab4Configuration {

    @Bean
    @Scope("singleton")
    public SimpleRepository<SolveResult> solveResultRepository() {
        return new FileRepository();
    }

    @Bean
    @Scope("singleton")
    public EuclidSolver euclidSolver() {
        return new EuclidSolverImpl();
    }

}
