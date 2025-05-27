package utils;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "userProfileData")
    public Object[][] userProfileData() {
        return new Object[][]{
                {"user-1", "john.doe@example.com"},
                {"user-2", "jane.smith@example.com"}
        };
    }

    @DataProvider(name = "productData")
    public Object[][] productData() {
        return new Object[][]{
                {"prod-1", "Laptop"},
                {"prod-2", "Smartphone"}
        };
    }

    @DataProvider(name = "paymentData")
    public Object[][] paymentData() {
        return new Object[][]{
                {"pay-1", "COMPLETED"},
                {"pay-2", "PENDING"}
        };
    }

    @DataProvider(name = "orderData")
    public Object[][] orderData() {
        return new Object[][]{
                {"order-1", "COMPLETED"},
                {"order-2", "PROCESSING"}
        };
    }
}
