package com.revivex.domain;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name="recovery_actions", uniqueConstraints=@UniqueConstraint(name="uk_action_idempotency", columnNames="idempotencyKey"))
public class RecoveryAction {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private RecoveryCase recoveryCase;
 private String actionType; private String idempotencyKey; private String executionMode; private String status;
 private String providerReference; private String shortUrl; private BigDecimal amount; private BigDecimal actualRecovered;
 private Instant createdAt; private Instant executedAt; private Instant reconciledAt;
 @Column(length=2000) private String message;
 public RecoveryAction(){}
 public RecoveryAction(RecoveryCase c,String type,String key,String mode,BigDecimal amount){this.recoveryCase=c;actionType=type;idempotencyKey=key;executionMode=mode;status="PENDING";this.amount=amount;actualRecovered=BigDecimal.ZERO;createdAt=Instant.now();}
 public Long getId(){return id;} public RecoveryCase getRecoveryCase(){return recoveryCase;} public String getActionType(){return actionType;} public String getIdempotencyKey(){return idempotencyKey;} public String getExecutionMode(){return executionMode;} public String getStatus(){return status;} public String getProviderReference(){return providerReference;} public String getShortUrl(){return shortUrl;} public BigDecimal getAmount(){return amount;} public BigDecimal getActualRecovered(){return actualRecovered;} public Instant getCreatedAt(){return createdAt;} public Instant getExecutedAt(){return executedAt;} public Instant getReconciledAt(){return reconciledAt;} public String getMessage(){return message;}
 public void executed(String ref,String url,String msg){status="ACTION_EXECUTED_PENDING";providerReference=ref;shortUrl=url;message=msg;executedAt=Instant.now();}
 public void simulatedRecovered(BigDecimal recovered){status="RECOVERED";actualRecovered=recovered;reconciledAt=Instant.now();}
 public void reconciled(String newStatus,BigDecimal recovered,String msg){status=newStatus;actualRecovered=recovered;message=msg;reconciledAt=Instant.now();}
}
