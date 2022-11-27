package com.valeron.lab4;

import com.valeron.lab4.dao.*;
import org.springframework.context.annotation.*;

@Configuration
public class Lab4Configuration {

    @Bean
    @Scope("singleton")
    public SimpleRepository simpleRepository() {
        return new FileRepository();
    }

}
