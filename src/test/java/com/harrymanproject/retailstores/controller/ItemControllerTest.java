package com.harrymanproject.retailstores.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrymanproject.retailstores.data.model.Category;
import com.harrymanproject.retailstores.data.model.Item;
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
class ItemControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenICallTheCreateItemPostMethod() throws Exception{
        Item item = new Item();
        item.setName("toy car");
        item.setCategory(Category.TOYS);

        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(post("/item/create")
        .contentType("application/json").content(mapper.writeValueAsString(item)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void whenICallFindItemByIdTest() throws Exception{
        this.mockMvc.perform(get("/item/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenICallFindAllItemsTest() throws Exception{
        this.mockMvc.perform(get("/item/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenICallDeleteTest() throws Exception{
        this.mockMvc.perform(get("/item/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}