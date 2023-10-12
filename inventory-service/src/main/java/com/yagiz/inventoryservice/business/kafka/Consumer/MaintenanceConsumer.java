package com.yagiz.inventoryservice.business.kafka.Consumer;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.Events.MaintenanceEvents.MaintenanceCreateEvent;
import com.yagiz.commonservice.utils.Kafka.Events.MaintenanceEvents.MaintenanceDeleteEvent;
import com.yagiz.inventoryservice.business.abstracts.CarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenanceConsumer {
    private final CarService service;

    public void consume(MaintenanceCreateEvent event){

    }

    public void consume(MaintenanceDeleteEvent event){
        
    }
}
