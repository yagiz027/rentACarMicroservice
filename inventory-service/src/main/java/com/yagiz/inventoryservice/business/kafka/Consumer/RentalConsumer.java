package com.yagiz.inventoryservice.business.kafka.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.Events.Rental.RentalCreateEvent;
import com.yagiz.commonservice.utils.Kafka.Events.Rental.RentalDeleteEvent;
import com.yagiz.inventoryservice.business.abstracts.CarService;
import com.yagiz.inventoryservice.entity.enums.State;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class RentalConsumer {
    private final CarService service;

    @KafkaListener(
        topics = "rental-created",
        groupId = "inventory-rental-created"
    )
    public void consume(RentalCreateEvent event){
        service.changeStateByCarId(State.RENTED, event.getCarId());
        log.info("Rented created and events consumed {}",event);
    }

    @KafkaListener(
        topics = "rental-deleted",
        groupId = "inventory-rental-deleted"
    )
    public void consume(RentalDeleteEvent event){
        service.changeStateByCarId(State.AVAILABLE, event.getCarId());
        log.info("Rental deleted and events consumed {}",event);
    }
}
