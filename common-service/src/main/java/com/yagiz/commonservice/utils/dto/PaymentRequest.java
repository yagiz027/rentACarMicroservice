package com.yagiz.commonservice.utils.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequest {
    @NotNull(message = "Card number cannot be empty")
    @Length(min = 16 , max = 16 , message = "Card number must be equal to 16 characters")
    private String cardNumber;

    @NotNull(message = "Card holder place cannot be empty")
    @Length(min = 5, message = "Card holder place cannot be shorter than 5 characters")
    private String cardHolder; 

    @Min(value = 2023, message = "Card expiration year place cannot be less than 2023")
    private int cardExpirationYear;

    @Min(value = 1)
    @Max(value = 12)
    private int cardExpirationMonth;

    @Length(min = 3, max = 3, message =  "Card CVV place must be equal to 3 characters")
    @NotBlank
    @NotNull(message =  "Card cvv place cannot be empty")
    private String cardCVV;
}
