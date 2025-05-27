package models.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRequest {
    private String productId;
    private boolean isActive;
    private BigDecimal price;
    private int stock;
    private String category;
    private String description;
    private String name;
}
