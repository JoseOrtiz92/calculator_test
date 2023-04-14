package com.example.calculatormicro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "v1")
public class CalculatorController {

    @Operation(description = "Endpoint para sumar 2 valores",
            summary = "Suma de 2 valores",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "BAD_REQUEST",
                            responseCode = "400"
                    ),
                    @ApiResponse(
                            description = "NOT_FOUND",
                            responseCode = "404"
                    ),
                    @ApiResponse(
                            description = "INTERNAL_SERVER_ERROR",
                            responseCode = "500"
                    )
            })
    @GetMapping(value = "/plus")
    public ResponseEntity<BigDecimal> plus(
                @RequestParam(value = "value1", required = true) BigDecimal value1,
                @RequestParam(value = "value2", required = true) BigDecimal value2
            ){
        return ResponseEntity.of(Optional.of(BigDecimal.ZERO));
    }
}
