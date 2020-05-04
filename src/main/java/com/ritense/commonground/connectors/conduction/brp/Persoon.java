package com.ritense.commonground.connectors.conduction.brp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persoon {
    @JsonProperty("burgerservicenummer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bsn;

    @JsonProperty("naam")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PersoonsNaam naam;

    @JsonProperty("geboorte")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        @JsonProperty("geslachtsnaam")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String geslachtsnaam;

        @JsonProperty("voorletters")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String voorletters;

        @JsonProperty("voorvoegsel")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String voorvoegsel;

        @JsonProperty("aanhef")
        @JsonInclude(JsonInclude.Include.NON_NULL)
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
            @JsonInclude(JsonInclude.Include.NON_NULL)
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
