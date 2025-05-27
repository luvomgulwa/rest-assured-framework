package models.response.orders;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private String orderId;
    private String userId;
    private List<Item> items;
}
