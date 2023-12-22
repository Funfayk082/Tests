import io.restassured.internal.common.assertion.Assertion;
import model.request.CategoryRequest;
import model.request.PetRequest;
import model.request.TagRequest;
import model.response.ApiResponse;
import model.response.PetResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Steps;

import java.util.ArrayList;

public class PetTests implements Steps {
    @Test(priority = 1)
    public void addNewPet() {
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        ArrayList<TagRequest> tags = new ArrayList<>();
        tags.add(new TagRequest(0L, "Кот"));
        CategoryRequest category = new CategoryRequest(0L, "Кот");
        PetResponse actualPet = PET_API_STEPS.addNewPet(new PetRequest(0L, category, "Лапик", photoUrls, tags, "В наличии" ));
        PetResponse expectedPet = new PetResponse(9223372036854775807L, category, "Лапик", photoUrls, tags, "В наличии" );
        Assert.assertEquals(actualPet, expectedPet);
    }

    @Test(priority = 2)
    public void updatePet() {
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        ArrayList<TagRequest> tags = new ArrayList<>();
        tags.add(new TagRequest(0L, "Кот"));
        CategoryRequest category = new CategoryRequest(0L, "Кот");
        PetResponse actualPet = PET_API_STEPS.updatePet(new PetRequest(0L, category, "Лапик", photoUrls, tags, "В наличии" ));
        PetResponse expectedPet = new PetResponse(9223372036854775807L, category, "Лапик", photoUrls, tags, "В наличии" );
        Assert.assertEquals(actualPet, expectedPet);
    }

    @Test(priority = 3)
    public void findPetsByStatus() {
        PET_API_STEPS.findPetsByStatus("sold");
    }

    @Test(priority = 4)
    public void getPetById() {
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        ArrayList<TagRequest> tags = new ArrayList<>();
        tags.add(new TagRequest(1L, "string"));
        CategoryRequest category = new CategoryRequest(1L, "string");
        PetResponse expectedPet = new PetResponse(1L, category, "doggie", photoUrls, tags, "available" );
        PetResponse actualPet = PET_API_STEPS.getPetById(1L);
        Assert.assertEquals(actualPet, expectedPet);
    }

    @Test(priority = 5)
    public void deletePetById() {
        ApiResponse expectedResponse = new ApiResponse(200, "unknown", "1");
        ApiResponse actualResponse = PET_API_STEPS.deletePetById(1L);
        Assert.assertEquals(actualResponse, expectedResponse);
    }
}
