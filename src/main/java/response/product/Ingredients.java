package response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ingredients {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("IngredientId")
    private int ingredientId;
    @JsonProperty("ProductId")
    private int productId;
    @JsonProperty("Ingredient")
    private Ingredient ingredient;
}
