package com.yagiz.maintenanceservice.api.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yagiz.commonservice.utils.dto.ClientResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "inventory-service", fallback = CarClientFallback.class)
public interface CarClient {
    
    @CircuitBreaker(name = "maintenanceToInventory")
    @GetMapping(value= "api/cars/check-car-available/{carId}")
    ClientResponse checkCarAvailibilty(@PathVariable int carId);
}
