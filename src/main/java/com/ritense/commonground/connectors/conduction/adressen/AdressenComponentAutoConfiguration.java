package com.ritense.commonground.connectors.conduction.adressen;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AdressenComponentAutoConfiguration {

    @Bean
    public AdressenComponent adressenComponent(
            final RestTemplate restTemplate,
            final ObjectMapper objectMapper
            ){
        return new AdressenComponent(restTemplate, objectMapper);
    }
}
