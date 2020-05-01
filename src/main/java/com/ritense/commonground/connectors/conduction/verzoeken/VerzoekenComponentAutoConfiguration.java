package com.ritense.commonground.connectors.conduction.verzoeken;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class VerzoekenComponentAutoConfiguration {

    @Bean
    public VerzoekenComponent verzoekenComponent(
        final RestTemplate restTemplate
    ){
        return new VerzoekenComponent(restTemplate);
    }
}
