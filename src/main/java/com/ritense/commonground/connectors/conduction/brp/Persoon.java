package com.ritense.commonground.connectors.conduction.brp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persoon {
    private UUID id;

    @JsonProperty("burgerservicenummer")
    private String bsn;

    @JsonProperty("naam")
    private PersoonsNaam naam;

    public Persoon() {
    }

    public String getBsn() {
        return bsn;
    }

    public PersoonsNaam getNaam() {
        return naam;
    }

    public class PersoonsNaam {
        private String geslachtsnaam;

        public PersoonsNaam() {
        }

        public String getGeslachtsnaam() {
            return geslachtsnaam;
        }
    }
}
