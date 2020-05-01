package com.ritense.commonground.connectors.conduction.brp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasisRegistratiePersonenComponent {
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://brp.processen.zaakonline.nl/";
    private final ObjectMapper objectMapper;

    public BasisRegistratiePersonenComponent(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Persoon getPersonByBsn(String apiKey, String bsn) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                BASE_URL + "ingeschrevenpersonen?burgerservicenummer=" +  bsn,
                HttpMethod.GET,
                request,
                String.class
        );
        Persoon persoon = objectMapper.readValue(response.getBody(), Persoon.class);

        return persoon;
    }

    public Persoon getPersonByPersoonId(String apiKey, String persoonId) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                BASE_URL + "ingeschrevenpersonen/uuid/" +  persoonId,
                HttpMethod.GET,
                request,
                String.class
        );
        Persoon persoon = objectMapper.readValue(response.getBody(), Persoon.class);

        return persoon;
    }
}
