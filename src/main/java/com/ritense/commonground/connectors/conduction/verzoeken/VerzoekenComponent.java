package com.ritense.commonground.connectors.conduction.verzoeken;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

public class VerzoekenComponent {
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://vrc.processen.zaakonline.nl/";

    public VerzoekenComponent(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }

    public List getAllVerzoekenByRequestType(String apiKey, String requestTypeUrl){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List> response = restTemplate.exchange(
                BASE_URL + "requests?requestType=" +  requestTypeUrl,
                HttpMethod.GET,
                request,
                List.class
        );
        return response.getBody();
    }

    public List changeVerzoekenStatus(String apiKey, String verzoekId, String organizationId, VerzoekStatus status){
        JSONObject requestBody = new JSONObject();
        requestBody.put("status", status);
        requestBody.put("organization", "https://wrc.processen.zaakonline.nl/organizations/" + organizationId);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(requestBody, headers);

        ResponseEntity<List> response = restTemplate.exchange(
                BASE_URL + "requests/" +  verzoekId,
                HttpMethod.PUT,
                request,
                List.class
        );
        return response.getBody();
    }
}
