package com.yagiz.rentalservice.api.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yagiz.commonservice.utils.dto.CarClientResponse;
import com.yagiz.commonservice.utils.dto.ClientResponse;

import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "inventory-service", fallback = CarClientFallback.class)
public interface CarClient {
    /**inventory-service ile iletişim kurulurken hata alındığında 
    yapılacak iletişimin tekrar sayısını ilgili service'in config dosyasında
    belirtmemizi sağlar. Belirtilen tekrar sayısı sonucunda iletişim başarılı
    bir şekild sağlanamaz ise fallback içerisinde belirtilen sınıfa gidilir ve hata mesajı döndürülür.*/
    @Retry(name = "rentalToInventory") 
    @GetMapping(value= "api/cars/check-car-available/{carId}")
    ClientResponse checkCarAvailibilty(@PathVariable int carId);

    @Retry(name = "rentalToInventory")
    @GetMapping(value = "api/cars/get-car/{carId}")
    CarClientResponse getCarForRental(@PathVariable int carId);
}
