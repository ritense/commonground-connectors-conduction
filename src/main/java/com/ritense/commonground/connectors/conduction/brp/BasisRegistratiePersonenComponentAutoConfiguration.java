package com.ritense.commonground.connectors.conduction.brp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class BasisRegistratiePersonenComponentAutoConfiguration {

    @Bean
    public BasisRegistratiePersonenComponent basisRegistratiePersonenComponent(
            final RestTemplate restTemplate,
            final ObjectMapper objectMapper
    )
    {
        return new BasisRegistratiePersonenComponent(restTemplate, objectMapper);
    }
}
