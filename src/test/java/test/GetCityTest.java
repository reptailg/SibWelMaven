package test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import request.GetCities;
import request.GetProduct;
import response.city.CityRootResponse;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class GetCityTest {

    private final String CHECKED_CITY = "Алматы";

    @Description("Check weight all products in city")
    @Test
    void checkWeightForAllProductsInCity(){
        int idCity = getFromCities(getFromCities(1).getTotal()).getList()
               .stream().filter(p->p.getName().equals(CHECKED_CITY)).findFirst()
                .get().getId();

        int totalProduct = getProductResponse(1, idCity, 1).jsonPath().getInt("Total");
        List<? extends Number> products = new ArrayList<>();
        for(int i = 1; totalProduct > 0; i++){
                products.addAll(getProductResponse(500, idCity, i).jsonPath().getList("List.Weight"));
            totalProduct -=500;
        }

        products.forEach(x-> assertNotEquals("0", x.toString(), "Product weight must be not 0"));


    }
    @Step("Get info from cities request")
    private CityRootResponse getFromCities(int perPage){
        return GetCities.getCities(perPage)
                .then()
                .statusCode(200)
                .extract().as(CityRootResponse.class);
    }

    @Step("Get info from  products request. Page {currentPage}")
    private Response getProductResponse(int perPage, int idCity, int currentPage){
        return GetProduct.getProduct(perPage, idCity, currentPage)
                .then()
                .extract().response();
    }

}
