package response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductOptionType {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("OraId")
    private int oraId;
    @JsonProperty("ProductOptionBaseTypeId")
    private int productOptionBaseTypeId;
    @JsonProperty("RegionId")
    private int regionId;
    @JsonProperty("LanguageId")
    private int languageId;
}
