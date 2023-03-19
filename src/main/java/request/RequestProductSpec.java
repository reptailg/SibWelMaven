package request;

import io.restassured.specification.RequestSpecification;

public class RequestProductSpec extends RequestCitySpec {
    private RequestProductSpec() {
        super();
    }

    public static RequestSpecification requestProductSpec(int perPage, int cityId, int currentPage, int languageId) {
        return requestSpec(perPage, currentPage)
                .params("CityId", cityId,
                "LanguageId", languageId);
    }

    public static RequestSpecification requestProductSpec(int perPage, int cityId) {
        return requestProductSpec(perPage, cityId, 1, 9);
    }
    public static RequestSpecification requestProductSpec(int perPage, int cityId, int currentPage) {
        return requestProductSpec(perPage, cityId, currentPage, 9);
    }
}
