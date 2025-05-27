package models.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentResponse {
    private String paymentId;
    private String orderId;
    private BigDecimal amount;
    private String paymentMethod;
    private String paymentStatus;
    private int[] transactionDate;
    private String currency;
    private String paymentGateway;
    private String transactionReference;
}
