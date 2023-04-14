package com.example.calculatormicro.service;

import com.example.calculatormicro.model.dto.TracerDTO;

import java.math.BigDecimal;

/**
 * The interface Calculator service.
 */
public interface CalculatorService {

    /**
     * Plus big decimal.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the big decimal
     */
    TracerDTO plus(BigDecimal value1, BigDecimal value2);

    /**
     * Subtract big decimal.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the big decimal
     */
    TracerDTO subtract(BigDecimal value1, BigDecimal value2);
}
