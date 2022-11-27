package com.valeron.lab4;

import com.valeron.lab4.dao.SimpleRepository;
import com.valeron.lab4.mocks.MockRepository;
import org.springframework.context.annotation.*;

@Configuration
public class Lab4TestConfiguration {

    @Primary
    @Bean
    @Scope("singleton")
    public SimpleRepository simpleRepositoryMock() {
        return new MockRepository();
    }

}
