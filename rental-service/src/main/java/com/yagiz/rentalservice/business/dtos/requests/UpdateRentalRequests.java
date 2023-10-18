package com.yagiz.rentalservice.business.dtos.requests;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateRentalRequests {
    @NonNull
    private int carId;
    @NonNull
    private int rentedForDays;
    private double dailyPrice;
    private LocalDate rentedAt;
}
