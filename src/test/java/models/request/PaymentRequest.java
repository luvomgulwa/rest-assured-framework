package models.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentRequest {
    private String productId;
    private BigDecimal amount;
    private String currency;
    private String transactionDate;
    private String orderId;
    private String paymentGateway;
    private String paymentMethod;
    private String paymentStatus;
    private String transactionReference;
}
