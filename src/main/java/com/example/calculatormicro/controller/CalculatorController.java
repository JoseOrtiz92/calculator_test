package com.example.calculatormicro.controller;

import com.example.calculatormicro.model.dto.ErrorResponse;
import com.example.calculatormicro.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The type Calculator controller.
 */
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "v1")
public class CalculatorController {

    /**
     * The Calculator service.
     */
    @Autowired
    private CalculatorService calculatorService;

    /**
     * Plus method controller.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the operation result
     */
    @Operation(description = "Endpoint para sumar 2 valores",
            summary = "Suma de 2 valores",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            description = "BAD_REQUEST",
                            responseCode = "400",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            description = "NOT_FOUND",
                            responseCode = "404",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            description = "INTERNAL_SERVER_ERROR",
                            responseCode = "500",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    )
            })
    @GetMapping(value = "/plus")
    public ResponseEntity<BigDecimal> plus(
                @NotNull(message = "El valor no puede ser null") @RequestParam(value = "value1", defaultValue = "0") BigDecimal value1,
                @NotNull(message = "El valor no puede ser null") @RequestParam(value = "value2", defaultValue = "0") BigDecimal value2
            ){
        BigDecimal result = calculatorService.plus(value1, value2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Subtract method controller.
     *
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the operation result
     */
    @Operation(description = "Endpoint para restar 2 valores",
            summary = "Resta de 2 valores",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            description = "BAD_REQUEST",
                            responseCode = "400",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            description = "NOT_FOUND",
                            responseCode = "404",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            description = "INTERNAL_SERVER_ERROR",
                            responseCode = "500",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))
                    )
            })
    @GetMapping(value = "/subtract")
    public ResponseEntity<BigDecimal> subtract(
            @NotNull(message = "El valor no puede ser null") @RequestParam(value = "value1", defaultValue = "0") BigDecimal value1,
            @NotNull(message = "El valor no puede ser null") @RequestParam(value = "value2", defaultValue = "0") BigDecimal value2
    ){
        BigDecimal result = calculatorService.subtract(value1, value2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
