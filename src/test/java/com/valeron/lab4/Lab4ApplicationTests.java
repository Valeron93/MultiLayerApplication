package com.valeron.lab4;

import com.valeron.lab4.dao.SimpleRepository;
import com.valeron.lab4.model.SolveWithoutStepsResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.*;

@SpringBootTest
class Lab4ApplicationTests {

	@Autowired
	private SimpleRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void addonRep() {
		repository.put(new SolveWithoutStepsResult(10));
		System.out.println(repository.getClass().getName());
	}

}
