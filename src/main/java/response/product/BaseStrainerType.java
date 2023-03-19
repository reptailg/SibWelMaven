package response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseStrainerType {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("StrainerTypes")
    private ArrayList<Object> strainerTypes;
    @JsonProperty("FilterField")
    private String filterField;
}
