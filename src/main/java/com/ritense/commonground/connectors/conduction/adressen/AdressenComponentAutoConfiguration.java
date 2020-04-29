package com.ritense.commonground.connectors.conduction.adressen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AdressenComponentAutoConfiguration {

    @Bean
    public AdressenComponent adressenComponent(
        final RestTemplate restTemplate
        ){
        return new AdressenComponent(restTemplate);
    }
}
