package com.yagiz.rentalservice.business.dtos.responses.get;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetRentalListResponses {
    private int id;
    private int carId;
    private int rentedForDays;
    private double dailyPrice;
    private double totalPrice;
    private LocalDate rentedAt;
}
