package com.yagiz.commonservice.utils.Kafka.Events.MaintenanceEvents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaintenanceCreateEvent {
    private int carId;
}
