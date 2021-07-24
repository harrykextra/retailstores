package com.harrymanproject.retailstores.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrymanproject.retailstores.data.model.Supermarket;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class SupermarketControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenICallTheCreateSupermarketPostMethod() throws Exception{
        Supermarket supermarket = new Supermarket();
        supermarket.setName("Cole's");
        supermarket.setAddress("4, Abiodun street, Ikeja, Lagos");
        supermarket.setEmailAddress("coles@gmail.com");
        supermarket.setContactNumber("090-9999-5555");

        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(post("/supermarket/create")
        .contentType("application/json").content(mapper.writeValueAsString(supermarket)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void whenICallFindAllSupermarkets() throws Exception{
        this.mockMvc.perform(get("/supermarket/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenICallFindSupermarketById() throws Exception{
        this.mockMvc.perform(get("/supermarket/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenICallDelete() throws Exception{
        this.mockMvc.perform(get("/supermarket/8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}