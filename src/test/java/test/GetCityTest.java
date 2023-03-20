package test;

import io.qameta.allure.Description;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import request.Cities;
import request.Product;

import java.util.*;


class GetCityTest {
    private final String CHECKED_CITY = "Алматы";

    @Description("Check weight all products in city")
    @Test
    void checkWeightForAllProductsInCity(){
        final int ID_CITY = Cities.getCityId(CHECKED_CITY);
        SoftAssertions softAssertions = new SoftAssertions();

        List<Integer> code = Product.getInfoAboutProduct("List.Code", ID_CITY);
        List<String> name = Product.getInfoAboutProduct("List.Name", ID_CITY);
        List<? extends Number> weight = Product.getInfoAboutProduct("List.Weight", ID_CITY);
        List<List<String>> products = new ArrayList<>();
        for (int i = 0; i < code.size(); i ++){
            products.add(i, Arrays.asList(code.get(i).toString(), name.get(i), weight.get(i).toString()));
        }
        products.forEach(x ->
                softAssertions.assertThat(x.get(2))
                        .as("Code %s, Name %s, Weight %s",
                                x.get(0),
                                x.get(1),
                                x.get(2)
                        )
                        .isNotEqualTo("0")
        );
        softAssertions.assertAll();
    }

}
