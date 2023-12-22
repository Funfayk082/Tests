package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.request.OrderRequest;
import model.response.ApiResponse;
import model.response.OrderResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class OrderApiSteps {
    private final String URL = "https://petstore.swagger.io/v2";

    @Step
    public OrderResponse placeOrderForAPet(OrderRequest request) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/store/order")
                .then()
                .assertThat()
                .statusCode(200).extract().as(OrderResponse.class);
    }

    @Step
    public OrderResponse getOrderById(Long id) {
        return given()
                .baseUri(URL)
                .when()
                .get("/store/order/" + id)
                .then()
                .assertThat()
                .statusCode(200).extract().as(OrderResponse.class);
    }

    @Step
    public ApiResponse deleteOrderById(Long id) {
        return given()
                .baseUri(URL)
                .when()
                .delete("/store/order/" + id)
                .then()
                .assertThat()
                .statusCode(200).extract().as(ApiResponse.class);
    }

    @Step
    public void getPetInventories() {
        given()
                .baseUri(URL)
                .when()
                .get("/store/inventory")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
