package com.revivex.repository;
import com.revivex.domain.RecoveryCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface RecoveryCaseRepository extends JpaRepository<RecoveryCase,Long>{
    List<RecoveryCase> findAllByOrderByDecidedAtDesc();
}
