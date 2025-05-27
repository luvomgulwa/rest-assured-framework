package models.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrdersRequest {
    private String orderId;
    private String userId;
    private String orderDate;
    private String status;
    private BigDecimal totalAmount;
}
