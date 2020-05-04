package com.ritense.commonground.connectors.conduction.adressen;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Adres {
    public Adres() {
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;

    @JsonProperty("huisnummer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Number huisnummer;

    @JsonProperty("postcode")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String postcode;

    @JsonProperty("huisnummertoevoeging")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String huisnummertoevoeging;

    @JsonProperty("straat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String straat;

    @JsonProperty("woonplaats")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
