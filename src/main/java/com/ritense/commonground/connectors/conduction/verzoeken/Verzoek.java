package com.ritense.commonground.connectors.conduction.verzoeken;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Verzoek {

    public Verzoek() {
    }

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("properties")
    private Properties properties;

    public class Properties {
        public Properties () {
        }

        @JsonProperty("datum")
        private String datum;

        @JsonProperty("verhuizenden")
        private String verhuizenden;

        @JsonProperty("adress")
        private String adress;

        public String getDatum() {
            return datum;
        }

        public String getVerhuizenden() {
            return verhuizenden;
        }

        public String getAdress() {
            return adress;
        }
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Properties getProperties() {
        return properties;
    }
}
