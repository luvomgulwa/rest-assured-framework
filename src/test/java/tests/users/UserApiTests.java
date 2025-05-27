package tests.users;

import config.RequestSpecFactory;
import endpoints.ApiEndpoint;
import io.restassured.response.Response;
import models.request.UserRequest;
import models.response.UserResponse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AssertionUtils;
import utils.DataProviderTest;
import utils.ResponseUtils;
import utils.TestDataGenerator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserApiTests {
    private UserRequest testUser;
    private UserResponse createdUser;

    @BeforeClass
    public void setupTestData() {
        testUser = TestDataGenerator.generateValidUser();
    }

    @Test(description = "Create a new user")
    public void testCreateUser() {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .body(testUser)
                .when()
                .post(ApiEndpoint.USERS);

        response.then().log().all();

        AssertionUtils.assertStatusCode(response, 201);
        AssertionUtils.assertContentType(response, "application/json");
        AssertionUtils.assertFieldEquals(response, "lastName", equalTo(testUser.getLastName()));

        createdUser = ResponseUtils.extractObject(response, UserResponse.class);
    }

    @Test(description = "Get all users")
    public void testGetAllUsers() {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .when()
                .get(ApiEndpoint.USERS);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 200);
    }

    @Test(description = "Get user by Id", dataProvider = "userProfileData", dataProviderClass = DataProviderTest.class)
    public void testGetUserById(String id, String email) {
        Response response = given()
                .spec(RequestSpecFactory.getDefaultRequestSpec())
                .pathParam("id", id)
                .when()
                .get(ApiEndpoint.USER_BY_ID);

        response.then().log().all();
        AssertionUtils.assertStatusCode(response, 200);
        AssertionUtils.assertFieldEquals(response, "userId", equalTo(id));
        AssertionUtils.assertFieldEquals(response, "email", equalTo(email));
    }

    @AfterClass
    public void cleanUp() {
        // Cleanup code for user profiles here
    }
}
