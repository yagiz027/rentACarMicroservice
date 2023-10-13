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
public class CarCreatedEvent implements Event{
    private int carId;
    private int modelId;
    private int brandId;
    private int modelYear;
    private String plate;
    private String state;
    private double dailyPrice;
    private String modelName;
    private String brandName;
}
