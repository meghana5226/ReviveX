package com.revivex.repository;
import com.revivex.domain.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface AuditEventRepository extends JpaRepository<AuditEvent,Long>{
    List<AuditEvent> findAllByOrderByCreatedAtDesc();
    List<AuditEvent> findByCaseIdOrderByCreatedAtDesc(Long caseId);
}
