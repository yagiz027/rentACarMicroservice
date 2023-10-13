package com.yagiz.maintenanceservice.api.clients;

import org.springframework.stereotype.Component;

import com.yagiz.commonservice.utils.dto.ClientResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CarClientFallback implements CarClient{ 
    @Override
    public ClientResponse checkCarAvailibilty(int carId) {
        log.info("INVENTORY-SERVICE DOWN");
        throw new RuntimeException("INVENTTORY-SERVICE NOT AVAILABLE RIGHT NOW");
    }
}
