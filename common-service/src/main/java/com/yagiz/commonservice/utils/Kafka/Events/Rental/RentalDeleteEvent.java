package com.yagiz.commonservice.utils.Kafka.Events.Rental;

import com.yagiz.commonservice.utils.Kafka.Events.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentalDeleteEvent implements Event{
    private int rentalId;
}
