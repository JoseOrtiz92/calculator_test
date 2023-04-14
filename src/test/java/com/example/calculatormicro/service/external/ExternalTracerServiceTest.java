package com.example.calculatormicro.service.external;

import com.example.calculatormicro.model.dto.TracerDTO;
import com.example.calculatormicro.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ExternalTracerService.class)
class ExternalTracerServiceTest {

    @SpyBean
    private ExternalTracerService externalTracerService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    void getTracer() {
        TracerDTO responseDTO = TracerDTO.builder().result("5").build();

        ReflectionTestUtils.setField(externalTracerService, "tracerUrl", "http://test.com");
        when(restTemplate.getForEntity(any(), any())).thenReturn(new ResponseEntity<>(responseDTO, HttpStatus.OK));

        TracerDTO tracerDTO = externalTracerService.getTracer(BigDecimal.TEN);

        assertEquals(tracerDTO.getResult(), responseDTO.getResult());
    }

    @Test
    void getTracerKO() {
        ReflectionTestUtils.setField(externalTracerService, "tracerUrl", "http://test.com");
        when(restTemplate.getForEntity(any(), any())).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> {
            restTemplate.getForEntity(URI.create("http://test.com"), TracerDTO.class);
        });
    }
}