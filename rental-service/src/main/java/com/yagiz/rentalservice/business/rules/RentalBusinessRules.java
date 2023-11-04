package com.yagiz.rentalservice.business.rules;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.commonservice.utils.dto.CreateRentalPaymentRequest;
import com.yagiz.rentalservice.api.clients.CarClient;
import com.yagiz.rentalservice.api.clients.PaymentClient;
import com.yagiz.rentalservice.repository.RentalRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RentalBusinessRules {
    private final RentalRepository rentalRepository;
    private final CarClient carClient;
    private final PaymentClient paymentClient;

    public void checkIfRentalExists(int id){
        if(!rentalRepository.existsById(id)){
            throw new BusinessException(Messages.Rental.NotExists);
        }
    }

    public void checkIfCarAvailable(int id){
        var response = carClient.checkCarAvailibilty(id);
        if(response.isSuccess()){
            throw new BusinessException(response.getMessage());
        }   
    }

    public void checkIfPaymentIsNotProcessed(CreateRentalPaymentRequest request){
        var response = paymentClient.processRentalToPayment(request);
        if(!response.isSuccess()){
            throw new BusinessException(response.getMessage());
        }
    }    
}
