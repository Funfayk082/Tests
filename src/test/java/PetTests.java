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
        PET_API_STEPS.addNewPet(new PetRequest(0L, category, "Pawny", photoUrls, tags, "available" ));
    }

    @Test(priority = 2)
    public void updatePet() {
        PET_API_STEPS.updatePet(new PetRequest(0L, category, "Лапик", photoUrls, tags, "В наличии" ));
    }

    @Test(priority = 3)
    public void findPetsByStatus() {
        PET_API_STEPS.findPetsByStatus("sold");
    }

    @Test(priority = 4)
    public void getPetById() {
        PET_API_STEPS.getPetById(1L);
    }

    @Test(priority = 5)
    public void deletePetById() {
        PET_API_STEPS.deletePetById(1L);
    }
}
