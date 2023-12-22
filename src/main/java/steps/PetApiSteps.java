package steps;

import io.qameta.allure.Step;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import model.request.PetRequest;
import model.response.ApiResponse;
import model.response.PetResponse;

import java.util.List;

public class PetApiSteps {
    private final String URL = "https://petstore.swagger.io/v2";
    @Step("Добавить питомца")
    public PetResponse addNewPet(PetRequest request) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .statusCode(200).extract().body().as(PetResponse.class);
    }

    @Step("Обновить питомца")
    public PetResponse updatePet(PetRequest request) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .put("/pet")
                .then()
                .assertThat()
                .statusCode(200).extract().body().as(PetResponse.class);
    }

    @Step
    public List<PetResponse> findPetsByStatus(String status) {
        return given()
                .baseUri(URL)
                .param("status", status)
                .when()
                .get("/pet/findByStatus")
                .then()
                .assertThat()
                .statusCode(200).extract().jsonPath().getList("data", PetResponse.class);
    }

    @Step
    public PetResponse getPetById(Long id) {
        return given()
                .baseUri(URL)
                .when()
                .get("/pet/"+id)
                .then()
                .assertThat()
                .statusCode(200).extract().as(PetResponse.class);
    }

    @Step
    public ApiResponse deletePetById(Long id) {
        return given()
                .baseUri(URL)
                .when()
                .delete("/pet/"+id)
                .then()
                .assertThat()
                .statusCode(200).extract().as(ApiResponse.class);
    }
}
