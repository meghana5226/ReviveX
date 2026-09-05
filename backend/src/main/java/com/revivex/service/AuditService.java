package com.revivex.service;
import com.revivex.domain.AuditEvent;
import com.revivex.repository.AuditEventRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AuditService {
    private final AuditEventRepository repo;
    public AuditService(AuditEventRepository repo){this.repo=repo;}
    public void record(Long id,String type,String details){repo.save(new AuditEvent(id,type,details));}
    public List<AuditEvent> byCase(Long id){return repo.findByCaseIdOrderByCreatedAtDesc(id);}
    public List<AuditEvent> all(){return repo.findAllByOrderByCreatedAtDesc();}
}
