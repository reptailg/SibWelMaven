package request;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private Product() {
    }
    public static Response get(int perPage, int cityId, int currentPage){
        return RequestProductSpec.requestProductSpec(perPage, cityId, currentPage)
                .when()
//                .log().all()
                .get("/product");
    }

    public static int getCountOfProduct(int cityId){
        return getProducts(1,cityId,1).jsonPath().getInt("Total");
    }


    @Step("Get info from  products. Page {currentPage}")
    public static Response getProducts(int perPage, int idCity, int currentPage){
        return get(perPage, idCity, currentPage)
                .then()
                .extract().response();
    }

    @Step("Get {value} about all product")
    public static <T> List<T> getInfoAboutProduct(String value, int cityId){
        int countProduct = getCountOfProduct(cityId);
        List<T> listProducts = new ArrayList<>();
        for(int i = 1; countProduct > 0; i++){
            listProducts.addAll(getProducts(500, cityId, i)
                    .jsonPath().getList(value));
            countProduct -= 500;
        }
        return listProducts;
    }

}
