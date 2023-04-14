package com.example.calculatormicro.service.impl;

import com.example.calculatormicro.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal plus(BigDecimal value1, BigDecimal value2) {
        return value1.add(value2);
    }

    @Override
    public BigDecimal subtract(BigDecimal value1, BigDecimal value2) {
        return value1.subtract(value2);
    }
}
