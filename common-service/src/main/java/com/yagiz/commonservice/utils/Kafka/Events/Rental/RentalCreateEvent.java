package com.yagiz.commonservice.utils.Kafka.Events.Rental;

import java.time.LocalDate;

import com.yagiz.commonservice.utils.Kafka.Events.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentalCreateEvent implements Event {
    private int id;
    private int carId;
    private double dailyPrice;
    private double totalPrice;
    private LocalDate rentedAt;
}
