package com.revivex.repository;
import com.revivex.domain.PaymentEvent;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentEventRepository extends JpaRepository<PaymentEvent,Long>{}
