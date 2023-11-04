package com.yagiz.paymentservice.business.rules;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.commonservice.utils.dto.CreateRentalPaymentRequest;
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
        int localMonth = LocalDateTime.now().getMonth().getValue();

        if((expirationYear >= localYear  && expirationMonth >= localMonth) || (expirationYear <= localYear && expirationMonth > localMonth)){
            return true;
        }
        return false;
    }

    public void checkIfPaymentBalaceIsEnough(double balance, double price){
        if(balance < price){
            throw new BusinessException(Messages.Payment.NotEnoughMoney);
        }
    }

    public void ifPaymentIsValid(CreateRentalPaymentRequest paymentRequest){
        if(!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCVV(            
         paymentRequest.getCardNumber(),
         paymentRequest.getCardHolder(),
         paymentRequest.getCardExpirationYear(),
         paymentRequest.getCardExpirationMonth(),
         paymentRequest.getCardCVV()
         )){
            throw new BusinessException(Messages.Payment.PaymentIsNotValid);
         }  
    }
}
