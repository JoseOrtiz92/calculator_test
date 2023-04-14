package com.example.calculatormicro.controller;

import com.example.calculatormicro.model.dto.TracerDTO;
import com.example.calculatormicro.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculatorController.class)
class CalculatorControllerTest {

    @SpyBean
    private CalculatorController calculatorController;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void plus() {
        TracerDTO responseDTO = TracerDTO.builder().result("5").build();

        when(calculatorService.plus(any(BigDecimal.class), any(BigDecimal.class))).thenReturn(responseDTO);
        ResponseEntity<TracerDTO> response = calculatorController.plus(BigDecimal.TEN, BigDecimal.TEN);

        assertNotNull(response);
        assertEquals(responseDTO.getResult(), response.getBody().getResult());
    }

    @Test
    void plusKO() {
        when(calculatorService.plus(any(BigDecimal.class), any(BigDecimal.class))).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.plus(BigDecimal.TEN, BigDecimal.TEN);
        });
    }

    @Test
    void subtract() {
        TracerDTO responseDTO = TracerDTO.builder().result("5").build();

        when(calculatorService.subtract(any(BigDecimal.class), any(BigDecimal.class))).thenReturn(responseDTO);
        ResponseEntity<TracerDTO> response = calculatorController.subtract(BigDecimal.TEN, BigDecimal.TEN);

        assertNotNull(response);
        assertEquals(responseDTO.getResult(), response.getBody().getResult());
    }

    @Test
    void subtractKO() {
        when(calculatorService.subtract(any(BigDecimal.class), any(BigDecimal.class))).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.subtract(BigDecimal.TEN, BigDecimal.TEN);
        });
    }
}