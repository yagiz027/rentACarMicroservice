package com.yagiz.paymentservice.business.dtos.requests;

import com.yagiz.commonservice.utils.dto.PaymentRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePaymentRequest extends PaymentRequest{
    @NotNull(message = "Payment balance place cannot be empty")
    @Min(value = 1)
    private double balance;
}
