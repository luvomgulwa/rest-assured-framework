package utils;

import io.restassured.response.Response;

public class ResponseUtils {
    public static <T> T extractObject(Response response, Class<T> clazz) {
        return response.then()
                .extract()
                .as(clazz);
    }

    public  static String extractString(Response response, String path) {
        return response.then()
                .extract()
                .path(path);
    }

    public  static int extractInt(Response response, String path) {
        return response.then()
                .extract()
                .path(path);
    }

    public static Response extractResponse(Response response) {
        return response.then()
                .extract()
                .response();
    }
}
