package com.yagiz.rentalservice.business.dtos.requests;

import com.yagiz.commonservice.utils.dto.PaymentRequest;

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
    
    @Min(1)
    private int rentedForDays;

    @Min(1)
    private double dailyPrice;
    
    private PaymentRequest paymentRequest;
}
