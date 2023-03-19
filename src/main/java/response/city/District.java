package response.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class District {

    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("OraId")
    private int oraId;
    @JsonProperty("Cities")
    private Object cities;
    @JsonProperty("CountryId")
    private int countryId;
    @JsonProperty("OraParishId")
    private int oraParishId;
}
