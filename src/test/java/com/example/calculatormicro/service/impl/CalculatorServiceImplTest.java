package com.example.calculatormicro.service.impl;

import com.example.calculatormicro.controller.CalculatorController;
import com.example.calculatormicro.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalculatorServiceImpl.class)
class CalculatorServiceImplTest {

    @SpyBean
    private CalculatorService calculatorService;

//    @Test
//    void plus() {
//        BigDecimal result = calculatorService.plus(BigDecimal.TEN, BigDecimal.TEN);
//
//        assertNotNull(result);
//        assertEquals(result, BigDecimal.valueOf(20L));
//    }
//
//    @Test
//    void plusKO() {
//        assertThrows(NullPointerException.class, () -> {
//            calculatorService.plus(null, BigDecimal.TEN);
//        });
//    }
//
//    @Test
//    void subtract() {
//        BigDecimal result = calculatorService.subtract(BigDecimal.TEN, BigDecimal.TEN);
//
//        assertNotNull(result);
//        assertEquals(BigDecimal.ZERO, result);
//    }
//
//    @Test
//    void subtractKO() {
//        assertThrows(NullPointerException.class, () -> {
//            calculatorService.plus(null, BigDecimal.TEN);
//        });
//    }
}