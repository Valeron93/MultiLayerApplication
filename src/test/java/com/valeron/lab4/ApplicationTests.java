package com.valeron.lab4;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.util.Objects;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@PropertySource("classpath:application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationTests {

    @Autowired
    private MockMvc mvc;


    @Test
    public void contextLoads() {
        assertThat(mvc).isNotNull();
    }

    @AfterAll
    public void teardown(@Autowired Environment env) {
        System.out.println(env.getProperty("data.file.properties"));
    }


    @Test
    public void solve() throws Exception {
        String request = """
               {
               "input": [12, 18],
               "withSteps": false
               }
               """;

        mvc.perform(post(new URI("/solve")).contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("\"result\":6")));

    }

    @Test
    public void badRequest() throws Exception {
        mvc.perform(post(new URI("/solve")).contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void solveWithSteps() throws Exception {

        String request = """
               {
               "input": [12, 18],
               "withSteps": false
               }
               """;

        var r = post(new URI("/solve"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(request);

        mvc.perform(r).andExpect(status().isCreated());
    }

    @Test
    public void getSolved() throws Exception {

        String request = """
                {
                "input": [12, 18],
                "withSteps": false
                }
                """;

        var response = mvc.perform(post(new URI("/solve")).contentType(MediaType.APPLICATION_JSON).content(request)).
                andExpect(status().isCreated()).andReturn().getResponse();

        mvc.perform(get(new URI(Objects.requireNonNull(response.getHeader("Location"))))).andExpect(status().isOk());

    }

    @Test
    public void wrongNonNullInput() throws Exception {

        String request = """
                {
                "input": [-12, 18, 654],
                "withSteps": false
                }
                """;

        mvc.perform(post(new URI("/solve")).contentType(MediaType.APPLICATION_JSON).content(request)).
                andExpect(status().isBadRequest()).andReturn().getResponse();


    }

}