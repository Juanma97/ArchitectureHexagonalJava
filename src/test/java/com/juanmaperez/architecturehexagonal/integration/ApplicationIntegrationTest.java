package com.juanmaperez.architecturehexagonal.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juanmaperez.architecturehexagonal.ArchitecturehexagonalApplication;
import com.juanmaperez.architecturehexagonal.api.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldSaveAProduct() throws Exception {
        ProductVO productVO = ProductVO.builder().build();

        mockMvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(productVO)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteAProduct() throws Exception {
        ProductVO productVO = ProductVO.builder().id(1).build();

        mockMvc.perform(post("/products")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(productVO)));

        mockMvc.perform(delete("/products/{idToDelete}", 1)
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
