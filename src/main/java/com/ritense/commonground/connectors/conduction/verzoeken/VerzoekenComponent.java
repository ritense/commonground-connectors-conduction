package com.ritense.commonground.connectors.conduction.verzoeken;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ritense.commonground.connectors.conduction.brp.Persoon;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

    public Boolean changeVerzoekenStatus(String apiKey, String verzoekId, String organizationId, VerzoekStatus status){
        ObjectNode requestBody = new ObjectMapper().createObjectNode();
        requestBody.put("status", String.valueOf(status));
        requestBody.put("organization", "https://wrc.processen.zaakonline.nl/organizations/" + organizationId);
        requestBody.put("requeustType", "https://vtc.processen.zaakonline.nl/request_types/2bfb3cea-b5b5-459c-b3e0-e1100089a11a");
        requestBody.putArray("submitters");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", apiKey);
        HttpEntity request = new HttpEntity(requestBody, headers);

        ResponseEntity<HashMap> response = restTemplate.exchange(
                BASE_URL + "requests/" +  verzoekId,
                HttpMethod.PUT,
                request,
                HashMap.class
        );
        return response.getStatusCode().is2xxSuccessful();
    }
}
