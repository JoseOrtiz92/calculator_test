package com.example.calculatormicro.service;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal plus(BigDecimal value1, BigDecimal value2);

    BigDecimal subtract(BigDecimal value1, BigDecimal value2);
}
