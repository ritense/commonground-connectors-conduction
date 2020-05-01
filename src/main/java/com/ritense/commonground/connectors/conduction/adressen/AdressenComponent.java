package com.ritense.commonground.connectors.conduction.adressen;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class AdressenComponent {
    private final RestTemplate restTemplate;

    public AdressenComponent(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List getBagObjectByAdress(String apiKey, String postcode, String housenumber){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List> response = restTemplate.exchange(
                " https://as.processen.zaakonline.nl/adressen?postcode=" + postcode + "&huisnummer=" + housenumber,
                HttpMethod.GET,
                request,
                List.class
        );
        return response.getBody();
    }

    public List getBagObjectByAdress(String apiKey, String postcode, String houseNumber, String houseNumberAddition){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List> response = restTemplate.exchange(
                " https://as.processen.zaakonline.nl/adressen?postcode=" + postcode + "&huisnummer=" + houseNumber + "&huisnummertoevoeging=" + houseNumberAddition,
                HttpMethod.GET,
                request,
                List.class
        );
        return response.getBody();
    }

    public List getBagObjectByBagID(String apiKey, String bagID){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List> response = restTemplate.exchange(
                "https://as.processen.zaakonline.nl/adressen?bagid=" + bagID,
                HttpMethod.GET,
                request,
                List.class
        );
        return response.getBody();
    }
}
