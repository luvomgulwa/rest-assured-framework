package models.response.orders;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    private String productId;
    private int quantity;
    private BigDecimal unitPrice;
}
