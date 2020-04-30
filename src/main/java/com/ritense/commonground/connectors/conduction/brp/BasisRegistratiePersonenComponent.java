package com.ritense.commonground.connectors.conduction.brp;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class BasisRegistratiePersonenComponent {
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://brp.processen.zaakonline.nl/";

    public BasisRegistratiePersonenComponent(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Persoon> getPersonByBsn(String apiKey, String bsn){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List> response = restTemplate.exchange(
                BASE_URL + "ingeschrevenpersonen?burgerservicenummer=" +  bsn,
                HttpMethod.GET,
                request,
                List.class
        );
        return response.getBody();
    }
}
