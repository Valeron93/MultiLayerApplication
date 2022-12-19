package com.valeron.lab4.configuration;

import com.valeron.lab4.dao.*;
import com.valeron.lab4.model.*;
import com.valeron.lab4.solver.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.io.File;
import java.io.IOException;

@Configuration
public class Lab4Configuration {

    @Value("${data.path}")
    private String filePath;

    @Bean
    @Scope("singleton")
    public SimpleRepository<CalculationResult> solveResultRepository() throws IOException {
        return new CalculationResultFileStorage(new File(filePath));
    }

    @Bean
    @Scope("singleton")
    public EuclidSolver euclidSolver() {
        return new EuclidSolverImpl();
    }

}
