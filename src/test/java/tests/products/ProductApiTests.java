package tests.products;

import config.RequestSpecFactory;
import endpoints.ApiEndpoint;
import io.restassured.response.Response;
import models.request.ProductRequest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AssertionUtils;
import utils.DataProviderTest;
import utils.TestDataGenerator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProductApiTests {
    private ProductRequest productTest;

    @BeforeClass
    public void setupTestData() {
        productTest = TestDataGenerator.generateValidProduct();
    }

    @Test(description = "Get all products")
    public void testGetAllProducts() {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .when()
                .get(ApiEndpoint.PRODUCTS);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 200);
        // add more assertions
    }

    @Test(description = "Get product by Id", dataProvider = "productData", dataProviderClass = DataProviderTest.class)
    public void testGetProductById(String id, String name) {
        Response response =  given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("id", id)
                .when()
                .get(ApiEndpoint.PRODUCT_BY_ID);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 200);
        AssertionUtils.assertFieldEquals(response, "productId", equalTo(id));
        AssertionUtils.assertFieldEquals(response, "name", equalTo(name));
    }

    @Test(description = "Create a new product")
    public void testCreateProduct() {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .body(productTest)
                .when()
                .post(ApiEndpoint.PRODUCTS);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 201);
    }

    @AfterClass
    public void cleanUp() {
        // Cleanup code for products here
    }
}
