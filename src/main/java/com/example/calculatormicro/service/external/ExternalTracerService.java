package com.example.calculatormicro.service.external;

import com.example.calculatormicro.model.dto.TracerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExternalTracerService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${trace.serviceTrace.url}")
    private String tracerUrl;

    public TracerDTO getTracer(BigDecimal result) {
        UriComponentsBuilder uri = UriComponentsBuilder.fromUriString(tracerUrl);
        uri.queryParamIfPresent("result", Optional.ofNullable(result));

        ResponseEntity<TracerDTO> response = restTemplate.getForEntity(uri.build().toUri(), TracerDTO.class);

        return response.getBody();
    }
}
