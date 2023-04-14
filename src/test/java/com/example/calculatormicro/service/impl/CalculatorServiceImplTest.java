package com.example.calculatormicro.service.impl;

import com.example.calculatormicro.controller.CalculatorController;
import com.example.calculatormicro.model.dto.TracerDTO;
import com.example.calculatormicro.service.CalculatorService;
import com.example.calculatormicro.service.external.ExternalTracerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculatorServiceImpl.class)
class CalculatorServiceImplTest {

    @SpyBean
    private CalculatorService calculatorService;

    @MockBean
    private ExternalTracerService externalTracerService;

    @Test
    void plus() {
        TracerDTO responseDTO = TracerDTO.builder().result("5").build();
        when(externalTracerService.getTracer(any(BigDecimal.class))).thenReturn(responseDTO);
        TracerDTO result = calculatorService.plus(BigDecimal.TEN, BigDecimal.TEN);

        assertNotNull(result);
        assertEquals(result.getResult(), responseDTO.getResult());
    }

    @Test
    void plusKO() {
        assertThrows(NullPointerException.class, () -> {
            calculatorService.plus(null, BigDecimal.TEN);
        });
    }

    @Test
    void subtract() {
        TracerDTO responseDTO = TracerDTO.builder().result("5").build();
        when(externalTracerService.getTracer(any(BigDecimal.class))).thenReturn(responseDTO);
        TracerDTO result = calculatorService.subtract(BigDecimal.TEN, BigDecimal.TEN);

        assertNotNull(result);
        assertEquals(result.getResult(), responseDTO.getResult());
    }

    @Test
    void subtractKO() {
        assertThrows(NullPointerException.class, () -> {
            calculatorService.plus(null, BigDecimal.TEN);
        });
    }
}