package response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseLandingCompositionPercent {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
}
