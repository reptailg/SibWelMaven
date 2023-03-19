package request;

import io.restassured.response.Response;

public class GetProduct {
    private GetProduct() {
    }
    public static Response getProduct(int perPage, int cityId, int currentPage){
        return RequestProductSpec.requestProductSpec(perPage, cityId, currentPage)
                .when()
//                .log().all()
                .get("/product");
    }
}
