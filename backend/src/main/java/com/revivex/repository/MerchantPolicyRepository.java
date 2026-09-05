package com.revivex.repository;
import com.revivex.domain.MerchantPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface MerchantPolicyRepository extends JpaRepository<MerchantPolicy,Long>{
    Optional<MerchantPolicy> findByMerchant(String merchant);
}
