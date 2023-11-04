package com.yagiz.rentalservice.api.clients;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.commonservice.utils.dto.CarClientResponse;
import com.yagiz.commonservice.utils.dto.ClientResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class CarClientFallback implements CarClient{

    @Override
    public ClientResponse checkCarAvailibilty(int carId) {
        log.info("inventory service is down!");
        throw new BusinessException(Messages.Inventory.ServiceNotAvailable);
    }

    @Override
    public CarClientResponse getCar(int carId) {
        log.info("inventory service is down!");
        throw new BusinessException(Messages.Inventory.ServiceNotAvailable);
    }
}
