package com.yagiz.commonservice.utils.Kafka.Events.Maintenance;

import com.yagiz.commonservice.utils.Kafka.Events.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDeleteEvent implements Event{
    private int carId;
}
