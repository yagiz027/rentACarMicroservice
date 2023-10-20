package com.yagiz.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yagiz.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{
    boolean existsByCardNumber(String cardNumber);
}
