package request;

import base.Property;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RequestCitySpec {
    protected static Property property() {
        return new Property();
    }
    protected RequestCitySpec() {
    }

    public static RequestSpecification requestSpec(int perPage, int currentPage, int regionId) {
        return given()
                .baseUri(property().getProperty("url"))
                .header("token", property().getProperty("token"))
                .contentType(ContentType.JSON)
                .params("RegionId", regionId, "PerPage", perPage,
                        "CurrentPage", currentPage);
    }

    public static RequestSpecification requestSpec(int perPage, int currentPage){
        return requestSpec(perPage, currentPage, 22);
    }
    public static RequestSpecification requestSpec(int perPage){
        return requestSpec(perPage, 1, 22);
    }

    public static RequestSpecification requestSpec(){
        return requestSpec(10, 1,22);
    }
}
