package com.yagiz.inventoryservice.business.kafka.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.Events.MaintenanceEvents.MaintenanceCreateEvent;
import com.yagiz.commonservice.utils.Kafka.Events.MaintenanceEvents.MaintenanceDeleteEvent;
import com.yagiz.inventoryservice.business.abstracts.CarService;
import com.yagiz.inventoryservice.entity.enums.State;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenanceConsumer {
    private final CarService service;

    @KafkaListener(
        topics = "maintenance-created",
        groupId = "inventory-maintenance-created"
    )
    public void consume(MaintenanceCreateEvent event){
        service.changeStateByCarId(State.MAINTENANCE, event.getCarId());
        log.info("Maintenance created and events consumed {}", event);
    }

    @KafkaListener(
        topics = "maintenance-deleted",
        groupId = "inventory-maintenance-deleted"
    )
    public void consume(MaintenanceDeleteEvent event){
        service.changeStateByCarId(State.AVAILABLE, event.getCarId());
        log.info("Maintenance deleted and events consumed {}",event);
    }
}
