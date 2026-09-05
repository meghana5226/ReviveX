package com.revivex.domain;
import jakarta.persistence.*;

@Entity
@Table(name="merchant_policies")
public class MerchantPolicy {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String merchant;
    private int maxRetries;
    private int maxContacts;
    private int cooldownMinutes;
    private double highValueThreshold;
    private boolean allowCustomerNudge;
    private boolean allowB2BChaser;

    public MerchantPolicy(){}

    public MerchantPolicy(String merchant, int retries, int contacts, int cooldown,
                          double threshold, boolean nudge, boolean b2b) {
        this.merchant = merchant;
        this.maxRetries = retries;
        this.maxContacts = contacts;
        this.cooldownMinutes = cooldown;
        this.highValueThreshold = threshold;
        this.allowCustomerNudge = nudge;
        this.allowB2BChaser = b2b;
    }

    public Long getId(){ return id; }
    public String getMerchant(){ return merchant; }
    public int getMaxRetries(){ return maxRetries; }
    public int getMaxContacts(){ return maxContacts; }
    public int getCooldownMinutes(){ return cooldownMinutes; }
    public double getHighValueThreshold(){ return highValueThreshold; }
    public boolean isAllowCustomerNudge(){ return allowCustomerNudge; }
    public boolean isAllowB2BChaser(){ return allowB2BChaser; }
}
