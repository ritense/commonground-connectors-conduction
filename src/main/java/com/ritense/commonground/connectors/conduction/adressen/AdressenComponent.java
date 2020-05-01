package com.ritense.commonground.connectors.conduction.adressen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdressenComponent {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public AdressenComponent(
            RestTemplate restTemplate,
            ObjectMapper objectMapper
    ) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Adres getBagObjectByAdress(String apiKey, String postcode, String housenumber) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                " https://as.processen.zaakonline.nl/adressen?postcode=" + postcode + "&huisnummer=" + housenumber,
                HttpMethod.GET,
                request,
                String.class
        );

        Adres adres = objectMapper.readValue(response.getBody(), Adres.class);

        return adres;
    }

    public Adres getBagObjectByAdress(String apiKey, String postcode, String houseNumber, String houseNumberAddition) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                " https://as.processen.zaakonline.nl/adressen?postcode=" + postcode + "&huisnummer=" + houseNumber + "&huisnummertoevoeging=" + houseNumberAddition,
                HttpMethod.GET,
                request,
                String.class
        );
        Adres adres = objectMapper.readValue(response.getBody(), Adres.class);

        return adres;
    }

    public Adres getBagObjectByBagID(String apiKey, String bagID) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://as.processen.zaakonline.nl/adressen?bagid=" + bagID,
                HttpMethod.GET,
                request,
                String.class
        );
        Adres adres = objectMapper.readValue(response.getBody(), Adres.class);

        return adres;
    }
}
