package com.yagiz.paymentservice.business.rules;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.paymentservice.repository.PaymentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private PaymentRepository repository;

    public void checkIfPaymentNotExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Payment.NotExists);
        }
    }

    public void checkIfPaymentAlreadyExists(String cardNumber){
        if(repository.existsByCardNumber(cardNumber)){
            throw new BusinessException(Messages.Payment.AlreadyExists);
        }
    }
    public void checkIfPaymentExpirationDateExpired(int expirationYear,int expirationMonth){
        if(isPaymentExpired(expirationYear, expirationMonth)==true){
            throw new BusinessException(Messages.Payment.ExpirationDateExpired);
        }
    }

    private boolean isPaymentExpired(int expirationYear,int expirationMonth){
        int localYear = LocalDateTime.now().getYear();
        int localMont = LocalDateTime.now().getMonth().getValue();

        if((expirationYear < localYear && expirationMonth < localMont) || (expirationYear > localYear && expirationMonth < localMont)){
            return true;
        }
        return false;
    }
}
