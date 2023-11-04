package com.yagiz.commonservice.utils.Kafka.Events.RentalPaymentEvent;

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
public class CreateRentalPaymentEvent implements Event{
    private int carId;
    private String plate;
    private String carName;
    private String modelName;
    private String brandName;
    private int modelYear;
    private double dailyPrice;
    private double totalPrice;
    private int rentedForDays;
    private LocalDate rentedAt;
}
