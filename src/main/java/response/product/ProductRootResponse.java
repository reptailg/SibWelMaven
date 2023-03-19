package response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRootResponse {
    @JsonProperty("List")
    private List<ProductList> list;
    @JsonProperty("Total")
    private int total;

    public List<ProductList> getList() {
        return list;
    }

    public int getTotal() {
        return total;
    }
}
