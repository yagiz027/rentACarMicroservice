package com.yagiz.rentalservice.api.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yagiz.commonservice.utils.dto.ClientResponse;
import com.yagiz.commonservice.utils.dto.CreateRentalPaymentRequest;

import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "payment-service" , fallback = PaymentClientFallBack.class)
public interface PaymentClient {
    @Retry(name = "rentalToPayment")
    @GetMapping("/process-rental-payment")
    ClientResponse processRentalToPayment(@RequestBody CreateRentalPaymentRequest rentalPaymentRequest);
}   
