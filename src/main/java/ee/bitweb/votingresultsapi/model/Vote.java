package ee.bitweb.votingresultsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Vote {

    @JsonProperty("id")
    private long id;

    @JsonProperty("animalName")
    private String animalName;

    @JsonProperty("votesNumber")
    private int votesNumber;
}
