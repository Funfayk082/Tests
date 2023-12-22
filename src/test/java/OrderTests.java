import model.request.OrderRequest;
import model.response.ApiResponse;
import model.response.OrderResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Steps;

public class OrderTests implements Steps {
    @Test(priority = 1)
    public void placeOrderForAPet() {
        OrderResponse expectedResponse = new OrderResponse(1L,
                1L, 1000, "2023-12-20T07:37:49.532+0000",
                "placed", true);
        OrderResponse actualResponse = ORDER_API_STEPS.placeOrderForAPet(new OrderRequest(1L,
                1L, 1000, "2023-12-20T07:37:49.532Z",
                "placed", true));
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test(priority = 2)
    public void getOrderById() {
        OrderResponse expectedResponse = new OrderResponse(1L,
                1L, 1000, "2023-12-20T07:37:49.532+0000",
                "placed", true);
        OrderResponse actualResponse = ORDER_API_STEPS.getOrderById(1L);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test(priority = 3)
    public void deleteOrderById() {
        ApiResponse expectedResponse = new ApiResponse(200, "unknown", "1");
        ApiResponse actualResponse = ORDER_API_STEPS.deleteOrderById(1L);
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test(priority = 4)
    public void getPetInventories() {
        ORDER_API_STEPS.getPetInventories();
    }
}
