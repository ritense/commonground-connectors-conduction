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

    @JsonProperty("geboorte")
    private PersoonsGeboorte geboorte;

    public Persoon() {
    }

    public String getBsn() {
        return bsn;
    }

    public PersoonsNaam getNaam() {
        return naam;
    }

    public PersoonsGeboorte getGeboorte() {
        return geboorte;
    }

    public class PersoonsNaam {
        @JsonProperty("geslachtnaam")
        private String geslachtsnaam;

        @JsonProperty("voorletters")
        private String voorletters;

        @JsonProperty("voorvoegsel")
        private String voorvoegsel;

        @JsonProperty("aanhef")
        private String aanhef;

        public PersoonsNaam() {
        }

        public String getGeslachtsnaam() {
            return geslachtsnaam;
        }

        public String getVoorletters() {
            return voorletters;
        }

        public String getVoorvoegsel() {
            return voorvoegsel;
        }

        public String getAanhef() {
            return aanhef;
        }
    }

    public class PersoonsGeboorte{
        @JsonProperty("datum")
        private GeboorteDatum datum;

        public PersoonsGeboorte() {
        }

        public GeboorteDatum getDatum() {
            return datum;
        }

        public class GeboorteDatum{
            @JsonProperty("date")
            private String date;

            public GeboorteDatum() {
            }

            public String getDate() {
                return date;
            }
        }
    }
}
