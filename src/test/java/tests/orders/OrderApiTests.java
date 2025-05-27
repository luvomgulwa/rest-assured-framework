package tests.orders;

import config.RequestSpecFactory;
import endpoints.ApiEndpoint;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.AssertionUtils;
import utils.DataProviderTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class OrderApiTests {

    @Test(description = "Get All Orders")
    public void testGetAllOrders() {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .when()
                .get(ApiEndpoint.ORDERS);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 200);
    }

    @Test(description = "Get order by Id", dataProvider = "orderData", dataProviderClass = DataProviderTest.class)
    public void testGetOrderById(String orderId, String status) {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("id", orderId)
                .when()
                .get(ApiEndpoint.ORDER_BY_ID);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 200);
        AssertionUtils.assertFieldEquals(response, "status", equalTo(status));
    }
}
