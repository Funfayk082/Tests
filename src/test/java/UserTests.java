import model.request.UserRequest;
import model.response.ApiResponse;
import model.response.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Steps;

import java.util.ArrayList;
import java.util.List;

public class UserTests  implements Steps {
    @Test(priority = 10)
    public void getUserByUsername() {
        USER_API_STEPS.getUserByUsername("string");
    }

    @Test(priority = 11)
    public void updateUser() {
        UserRequest request = new UserRequest(0L, "ff", "string", "string", "string", "string", "string", 0L);
        USER_API_STEPS.updateUser("string", request);
    }

    @Test(priority = 12)
    public void deleteUser() {
        USER_API_STEPS.deleteUser("string");
    }

    @Test(priority = 13)
    public void login() {
        USER_API_STEPS.login("string", "12345678");
    }

    @Test(priority = 14)
    public void logout() {
        USER_API_STEPS.logout();
    }

    @Test(priority = 15)
    public void addUserList() {
        List<UserRequest> users = new ArrayList<>();
        users.add(new UserRequest(1L, "Funfayk082", "Андрей", "Зайцев", "Funfayk082@yandex.ru", "abc_123456", "88005553535", 1L));
        USER_API_STEPS.addUserList(users);
    }

    @Test(priority = 16)
    public void addUser() {
        UserRequest user = new UserRequest(0L, "FF", "A", "Z", "FF@mail.ru", "12345678", "string", 0L);
        USER_API_STEPS.addUser(user);
    }
}
