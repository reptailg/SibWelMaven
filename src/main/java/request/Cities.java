package request;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import response.city.CityList;
import response.city.CityRootResponse;

import java.util.List;

public class Cities {
    private Cities() {
    }

    private static Response get(int perPage){
        return RequestCitySpec.requestSpec(perPage)
                .when()
                .get("/city");
    }

    public static CityRootResponse getCities(int perPage){
        return get(perPage)
                .then()
                .statusCode(200)
                .extract().as(CityRootResponse.class);
    }

    @Step("Get count of cities")
    public static int getCountOfCities(){
        return getCities(1).getTotal();
    }

    @Step("Get list of cities")
    public static List<CityList> getListOfCities(){
        return getCities(getCountOfCities()).getList();
    }

    @Step("Get city {cityName} ID")
    public static int getCityId(String cityName){
        return getListOfCities().stream()
                .filter(p->p.getName().equals(cityName))
                .findFirst()
                .get().getId();
    }
}
