package utils;

import io.restassured.response.Response;
import org.hamcrest.Matcher;

public class AssertionUtils {
    public static void assertStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    public static void assertFieldEquals(Response response, String fieldPath, Matcher<?> matcher) {
        response.then().body(fieldPath, matcher);
    }

    public static void assertResponseTimeLessThan(Response response, long milliseconds) {
        response.then().time(org.hamcrest.Matchers.lessThan(milliseconds));
    }

    public  static void assertContentType(Response response, String contentType) {
        response.then().contentType(contentType);
    }
}
