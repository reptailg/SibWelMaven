package response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LandingCompositionUnit {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("RegionId")
    private int regionId;
    @JsonProperty("LanguageId")
    private int languageId;
    @JsonProperty("BaseLandingCompositionUnitId")
    private int baseLandingCompositionUnitId;
    @JsonProperty("BaseLandingCompositionUnit")
    private BaseLandingCompositionUnit baseLandingCompositionUnit;
}
