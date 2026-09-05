package com.revivex.engine;
import com.revivex.domain.PaymentEvent;
import org.springframework.stereotype.Component;
@Component
public class RootCauseEngine {
    public String classify(PaymentEvent p){
        if("CHECKOUT_ABANDONED".equals(p.getEventType())) return "CHECKOUT_ABANDONMENT";
        if("SUBSCRIPTION_FAILED".equals(p.getEventType())) return "SUBSCRIPTION_PAYMENT_FAILURE";
        if("MANDATE_FAILED".equals(p.getEventType())) return "MANDATE_DEGRADATION";
        if("INVOICE_OVERDUE".equals(p.getEventType())) return "OVERDUE_RECEIVABLE";
        return switch(p.getFailureCode().toUpperCase()){
            case "BANK_TIMEOUT","GATEWAY_TIMEOUT","ISSUER_UNAVAILABLE" -> "TRANSIENT_BANK_ERROR";
            case "INSUFFICIENT_FUNDS","AUTH_REQUIRED","OTP_TIMEOUT" -> "CUSTOMER_ACTION_REQUIRED";
            case "FRAUD_SUSPECTED","LIMIT_EXCEEDED" -> "NON_RETRYABLE";
            default -> "UNKNOWN_PAYMENT_FAILURE";
        };
    }
}
