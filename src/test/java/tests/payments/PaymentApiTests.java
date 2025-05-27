package tests.payments;

import config.RequestSpecFactory;
import endpoints.ApiEndpoint;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.AssertionUtils;
import utils.DataProviderTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PaymentApiTests {

    @Test(description = "Get all Payments transactions")
    public void testGetAllPaymentsTransactions() {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .when()
                .get(ApiEndpoint.PAYMENTS);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 200);
    }

    @Test(description = "Get payment by Id", dataProvider = "paymentData", dataProviderClass = DataProviderTest.class)
    public void testGetPaymentById(String paymentId, String paymentStatus) {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("id", paymentId)
                .when()
                .get(ApiEndpoint.PAYMENT_BY_ID);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 200);
        AssertionUtils.assertFieldEquals(response, "paymentStatus", equalTo(paymentStatus));
    }
}
