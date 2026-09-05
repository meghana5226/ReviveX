package com.revivex;
import com.revivex.domain.*; import com.revivex.engine.*; import org.junit.jupiter.api.Test; import java.math.BigDecimal; import static org.junit.jupiter.api.Assertions.*;
class EngineTest {
 private PaymentEvent p(String code,int attempts,int contacts,boolean risk){return new PaymentEvent("Test","Acme",BigDecimal.valueOf(10000),"PAYMENT_FAILED",code,"CARD",attempts,contacts,.90,risk);}
 @Test void transientFailureScoresHigherThanPermanent(){RecoveryScorer s=new RecoveryScorer();assertTrue(s.score(p("BANK_TIMEOUT",0,0,false),"TRANSIENT_BANK_ERROR")>s.score(p("LIMIT_EXCEEDED",0,0,false),"NON_RETRYABLE"));}
 @Test void highRiskForcesStopCandidate(){InterventionOptimizer o=new InterventionOptimizer();assertEquals("STOP",o.optimize(p("FRAUD_SUSPECTED",0,0,true),"NON_RETRYABLE",.2).action());}
 @Test void policyBlocksHighRisk(){PolicyEngine e=new PolicyEngine();MerchantPolicy m=new MerchantPolicy("Acme",3,2,24,25000,true,true);var d=e.check(p("FRAUD_SUSPECTED",0,0,true),m,"SMART_RETRY");assertFalse(d.allowed());assertEquals("BLOCK_HIGH_RISK",d.rule());}
 @Test void terminalStateCannotMoveBack(){RecoveryCase c=new RecoveryCase(p("BANK_TIMEOUT",0,0,false),"TRANSIENT_BANK_ERROR","SMART_RETRY",.8,BigDecimal.valueOf(8000),BigDecimal.valueOf(7999),.9,"STOP_AFTER_SUCCESS_OR_POLICY_BOUNDARY","reason","allowed");c.recovered(BigDecimal.valueOf(8000));assertThrows(IllegalStateException.class,()->c.pending());}
}