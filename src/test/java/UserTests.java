import model.request.UserRequest;
import model.response.ApiResponse;
import model.response.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Steps;

import java.util.ArrayList;
import java.util.List;

public class UserTests  implements Steps {
    @Test(priority = 1)
    public void getUserByUsername() {
        UserResponse expectedResponse = new UserResponse(9223372036854775807L, "string", "string", "string", "string", "string", "string", 0);
        UserResponse actualResponse = USER_API_STEPS.getUserByUsername("string");
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test(priority = 2)
    public void updateUser() {
        UserRequest request = new UserRequest(0L, "ff", "string", "string", "string", "string", "string", 0L);
        ApiResponse expectedResponse = new ApiResponse(200, "unknown", "9223372036854775807");
        ApiResponse actualResponse = USER_API_STEPS.updateUser("string", request);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test(priority = 3)
    public void deleteUser() {
        ApiResponse expectedResponse = new ApiResponse(200, "unknown", "string");
        ApiResponse actualResponse = USER_API_STEPS.deleteUser("string");
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test(priority = 4)
    public void login() {
        ApiResponse actualResponse = USER_API_STEPS.login("string", "12345678");
    }

    @Test(priority = 5)
    public void logout() {
        ApiResponse expectedResponse = new ApiResponse(200, "unknown", "ok");
        ApiResponse actualResponse = USER_API_STEPS.logout();
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test(priority = 6)
    public void addUserList() {
        List<UserRequest> users = new ArrayList<>();
        users.add(new UserRequest(1L, "Funfayk082", "Андрей", "Зайцев", "Funfayk082@yandex.ru", "abc_123456", "88005553535", 1L));
        ApiResponse expectedResponse = new ApiResponse(200, "unknown", "ok");
        ApiResponse actualResponse = USER_API_STEPS.addUserList(users);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test(priority = 7)
    public void addUser() {
        UserRequest user = new UserRequest(0L, "FF", "A", "Z", "FF@mail.ru", "12345678", "string", 0L);
        ApiResponse expectedResponse = new ApiResponse(200, "unknown", "9223372036854775807");
        ApiResponse actualResponse = USER_API_STEPS.addUser(user);
        Assert.assertEquals(actualResponse, expectedResponse);
    }
}
