package com.yagiz.rentalservice.business.dtos.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateRentalResponses {
    private int id;
    private int carId;
    private String carName;
    private String modelName;
    private String brandName;
    private int rentedForDays;
    private double dailyPrice;
    private double totalPrice;
    private LocalDate rentedAt;
}
