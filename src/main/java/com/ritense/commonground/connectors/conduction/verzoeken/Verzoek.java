package com.ritense.commonground.connectors.conduction.verzoeken;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String datum;

        @JsonProperty("wie")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private ArrayList wie;

        @JsonProperty("adress")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String adress;

        @JsonProperty("email")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String email;

        @JsonProperty("tel")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String tel;

        @JsonProperty("eigenaar")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean eigenaar;

        @JsonProperty("ingangsdatum")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String ingangsdatum;

        public String getDatum() {
            return datum;
        }

        public ArrayList getWie() {
            return wie;
        }

        public String getAdress() {
            return adress;
        }

        public String getEmail() {
            return email;
        }

        public String getTel() {
            return tel;
        }

        public Boolean getEigenaar() {
            return eigenaar;
        }

        public String getIngangsdatum() {
            return ingangsdatum;
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
