package com.yagiz.inventoryservice.business.rules;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.inventoryservice.entity.enums.State;
import com.yagiz.inventoryservice.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CarBusinessRules {
    private final CarRepository repository;

    public void checkIfCarNotExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Car.NotAvailable);
        }
    }

    public void checkIfCarIsAvailable(int id){
        var car= repository.findById(id).orElseThrow(()-> new BusinessException(Messages.Car.NotExists));
        if(!car.getState().equals(State.AVAILABLE)){
            throw new BusinessException(Messages.Car.NotAvailable);
        }
    }
}
