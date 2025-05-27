package endpoints;

public class ApiEndpoint {
    // Authentication endpoints
    public static final String AUTH = "/auth";
    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";

    // User endpoints
    public static final String USERS = "/user-profiles";
    public static final String USER_BY_ID = USERS + "/{id}";

    // Product endpoints
    public static final String PRODUCTS = "/products";
    public static final String PRODUCT_BY_ID = PRODUCTS + "/{id}";

    // Payment endpoints
    public static final String PAYMENTS = "/payments";
    public static final String PAYMENT_BY_ID = PAYMENTS + "/{id}";

    // Orders endpoints
    public static final String ORDERS = "/orders";
    public static final String ORDER_BY_ID = ORDERS + "/{id}";
}
