package com.example.calculatormicro.service.impl;

import com.example.calculatormicro.model.dto.TracerDTO;
import com.example.calculatormicro.service.CalculatorService;
import com.example.calculatormicro.service.external.ExternalTracerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * The type Calculator service impl.
 */
@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private ExternalTracerService externalTracerService;

    @Override
    public TracerDTO plus(BigDecimal value1, BigDecimal value2) {
        BigDecimal result = value1.add(value2);
        return externalTracerService.getTracer(result);
    }

    @Override
    public TracerDTO subtract(BigDecimal value1, BigDecimal value2) {
        BigDecimal result = value1.subtract(value2);
        return externalTracerService.getTracer(result);
    }
}
