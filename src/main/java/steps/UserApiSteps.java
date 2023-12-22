package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.request.UserRequest;
import model.response.ApiResponse;
import model.response.UserResponse;

import java.util.List;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class UserApiSteps {
    private final String URL = "https://petstore.swagger.io/v2";

    @Step
    public UserResponse getUserByUsername(String username) {
        return given()
                .baseUri(URL)
                .when()
                .get("/user/" + username)
                .then()
                .assertThat()
                .statusCode(200).extract().as(UserResponse.class);
    }

    @Step
    public ApiResponse updateUser(String username, UserRequest request) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .put("/user/" + username)
                .then()
                .assertThat()
                .statusCode(200).extract().as(ApiResponse.class);
    }

    @Step
    public ApiResponse deleteUser(String username) {
        return given()
                .baseUri(URL)
                .when()
                .delete("/user/" + username)
                .then()
                .assertThat()
                .statusCode(200).extract().as(ApiResponse.class);
    }

    @Step
    public ApiResponse login(String username, String password) {
        return given()
                .baseUri(URL)
                .param("username", username)
                .param("password", password)
                .when()
                .get("/user/login")
                .then()
                .assertThat()
                .statusCode(200).extract().as(ApiResponse.class);
    }

    @Step
    public ApiResponse logout() {
        return given()
                .baseUri(URL)
                .when()
                .get("/user/logout")
                .then()
                .assertThat()
                .statusCode(200).extract().as(ApiResponse.class);
    }

    @Step
    public ApiResponse addUserList(List<UserRequest> request) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/user/createWithArray")
                .then()
                .assertThat()
                .statusCode(200).extract().as(ApiResponse.class);
    }

    @Step
    public ApiResponse addUser(UserRequest request) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/user")
                .then()
                .assertThat()
                .statusCode(200).extract().as(ApiResponse.class);
    }
}
