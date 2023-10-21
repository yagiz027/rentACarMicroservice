package com.yagiz.rentalservice.api.clients;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.commonservice.utils.dto.ClientResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class PaymentClientFallBack implements PaymentClient {@Override
    public ClientResponse processRentalToPayment(int id) {
        log.info("payment-service is down");
        throw new BusinessException(Messages.Payment.ServiceNotAvailable);
    }
    
}
