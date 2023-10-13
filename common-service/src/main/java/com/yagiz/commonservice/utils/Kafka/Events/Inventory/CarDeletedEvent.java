package com.yagiz.commonservice.utils.Kafka.Events.Inventory;

import com.yagiz.commonservice.utils.Kafka.Events.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDeletedEvent implements Event {
    private int carId;
}
