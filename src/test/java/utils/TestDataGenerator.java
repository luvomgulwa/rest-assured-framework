package utils;

import com.github.javafaker.Faker;
import models.request.ProductRequest;
import models.request.UserRequest;

import java.math.BigDecimal;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    // Generate user details
    public static UserRequest generateValidUser() {
        return UserRequest.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .isActive(true)
                .phone(faker.phoneNumber().phoneNumber())
                .address(faker.address().fullAddress())
                .build();
    }

    // Generate Product details
    public static ProductRequest generateValidProduct() {
        BigDecimal price = new BigDecimal(faker.commerce().price().replace(",", "."));

        return ProductRequest.builder()
                .name(faker.commerce().productName())
                .description(faker.lorem().sentence())
                .price(price)
                .category(faker.commerce().department())
                .stock(faker.number().randomDigitNotZero())
                .isActive(true)
                .build();
    }
}
