package response.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Area {

    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("DistrictId")
    private int districtId;
    @JsonProperty("CountryId")
    private int countryId;
    @JsonProperty("OraId")
    private int oraId;

}
