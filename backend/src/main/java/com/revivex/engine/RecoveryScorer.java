package com.revivex.engine;
import com.revivex.domain.PaymentEvent;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.time.Instant;
@Component
public class RecoveryScorer {
    public double score(PaymentEvent p,String cause){
        double s=.30;
        s += clamp((p.getHistoricalSuccessRate()-.50)*.55,-.12,.28);
        if(cause.equals("TRANSIENT_BANK_ERROR")) s+=.22;
        if(cause.equals("CUSTOMER_ACTION_REQUIRED")) s+=.12;
        if(cause.equals("CHECKOUT_ABANDONMENT")) s+=.16;
        if(cause.equals("SUBSCRIPTION_PAYMENT_FAILURE")) s+=.18;
        if(cause.equals("MANDATE_DEGRADATION")) s+=.15;
        if(cause.equals("OVERDUE_RECEIVABLE")) s+=.20;
        if(cause.equals("NON_RETRYABLE")) s-=.35;
        if(p.getAmount()!=null){
            if(p.getAmount().doubleValue()>=25000) s+=.05;
            if(p.getAmount().doubleValue()>=100000) s-=.04;
        }
        if(p.getPreviousAttempts()>=1) s-=.08;
        if(p.getPreviousAttempts()>=2) s-=.10;
        if(p.getPreviousContacts()>=1) s-=.05;
        if(p.getPreviousContacts()>=2) s-=.12;
        if(p.getOccurredAt()!=null){
            long hours=Math.max(0,Duration.between(p.getOccurredAt(),Instant.now()).toHours());
            if(hours<=6) s+=.06;
            else if(hours>72) s-=.08;
        }
        if(p.isHighRisk()) s-=.30;
        return clamp(s,.02,.96);
    }
    private double clamp(double v,double lo,double hi){return Math.max(lo,Math.min(hi,v));}
}
