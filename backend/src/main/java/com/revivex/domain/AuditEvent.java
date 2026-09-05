package com.revivex.domain;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name="audit_events")
public class AuditEvent {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private Long caseId; private String eventType;
    @Column(length=3000) private String details; private Instant createdAt;
    public AuditEvent(){}
    public AuditEvent(Long caseId,String type,String details){this.caseId=caseId;this.eventType=type;this.details=details;this.createdAt=Instant.now();}
    public Long getId(){return id;} public Long getCaseId(){return caseId;} public String getEventType(){return eventType;}
    public String getDetails(){return details;} public Instant getCreatedAt(){return createdAt;}
}
