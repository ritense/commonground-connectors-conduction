package com.ritense.commonground.connectors.conduction.adressen;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Adres {
    public Adres() {
    }

    @JsonProperty("type")
    private String type;

    @JsonProperty("huisnummer")
    private Number huisnummer;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("huisnummertoevoeging")
    private String huisnummertoevoeging;

    @JsonProperty("straat")
    private String straat;

    @JsonProperty("woonplaats")
    private String woonplaats;

    public String getType() {
        return type;
    }

    public Number getHuisnummer() {
        return huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getHuisnummertoevoeging() {
        return huisnummertoevoeging;
    }

    public String getStraat() {
        return straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }
}
