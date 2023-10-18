package com.yagiz.rentalservice.business.dtos.requests;

import java.time.LocalDate;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRentalRequest {
    @NonNull
    private int carId;
    
    @Min(value = 1)
    private int rentedForDays;
    
    @Min(value = 1)
    private double dailyPrice;
    
    private LocalDate rentedAt;
}
