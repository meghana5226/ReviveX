package com.revivex.config;

import com.revivex.domain.*;
import com.revivex.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class DemoData {
 @Bean CommandLineRunner seed(PaymentEventRepository p,MerchantPolicyRepository m){
  return args->{
   if(m.count()==0){
    m.save(new MerchantPolicy("Acme Commerce",2,3,120,25000,true,true));
    m.save(new MerchantPolicy("Northstar SaaS",2,2,180,25000,true,true));
   }
   if(p.count()==0){
    add(p,"Aarav Retail","Acme Commerce",4200,"PAYMENT_FAILED","BANK_TIMEOUT","UPI",0,0,.91,false);
    add(p,"Maya Foods","Acme Commerce",12500,"PAYMENT_FAILED","INSUFFICIENT_FUNDS","CARD",1,0,.76,false);
    add(p,"Northstar Labs","Northstar SaaS",48000,"INVOICE_OVERDUE","INVOICE_OVERDUE","B2B",0,0,.84,false);
    add(p,"Kite Commerce","Acme Commerce",1850,"PAYMENT_FAILED","OTP_TIMEOUT","CARD",0,1,.62,false);
    add(p,"UrbanNest","Acme Commerce",7600,"PAYMENT_FAILED","GATEWAY_TIMEOUT","UPI",1,0,.88,false);
    add(p,"Nova Health","Acme Commerce",23000,"PAYMENT_FAILED","FRAUD_SUSPECTED","CARD",0,0,.22,true);
    add(p,"BluePeak","Acme Commerce",3100,"PAYMENT_FAILED","AUTH_REQUIRED","CARD",0,0,.69,false);
    add(p,"Orbit Stores","Acme Commerce",9100,"PAYMENT_FAILED","BANK_TIMEOUT","UPI",2,0,.81,false);
    add(p,"CraftCart","Acme Commerce",2700,"PAYMENT_FAILED","LIMIT_EXCEEDED","CARD",0,0,.31,false);
    add(p,"Acme SaaS","Northstar SaaS",15900,"SUBSCRIPTION_FAILED","GATEWAY_TIMEOUT","CARD",0,0,.93,false);
    add(p,"GlowKart","Acme Commerce",6400,"CHECKOUT_ABANDONED","NONE","WEB",0,0,.74,false);
    add(p,"MangoMart","Acme Commerce",11200,"CHECKOUT_ABANDONED","NONE","WEB",0,1,.81,false);
    add(p,"PixelCloud","Northstar SaaS",22000,"MANDATE_FAILED","ISSUER_UNAVAILABLE","BANK",0,0,.87,false);
    add(p,"GreenGrid","Northstar SaaS",34000,"INVOICE_OVERDUE","INVOICE_OVERDUE","B2B",0,1,.79,false);
    add(p,"MetroHome","Acme Commerce",5800,"PAYMENT_FAILED","BANK_TIMEOUT","UPI",3,2,.89,false);
    add(p,"ZenLearn","Northstar SaaS",14500,"SUBSCRIPTION_FAILED","INSUFFICIENT_FUNDS","CARD",1,1,.72,false);
    add(p,"QuickBasket","Acme Commerce",3900,"PAYMENT_FAILED","ISSUER_UNAVAILABLE","UPI",0,0,.86,false);
    add(p,"IronWorks","Northstar SaaS",67000,"INVOICE_OVERDUE","INVOICE_OVERDUE","B2B",1,1,.91,false);
   }
  };
 }
 private void add(PaymentEventRepository r,String customer,String merchant,double amount,String event,String failure,
                  String channel,int attempts,int contacts,double success,boolean risk){
  r.save(new PaymentEvent(customer,merchant,BigDecimal.valueOf(amount),event,failure,channel,attempts,contacts,success,risk));
 }
}
