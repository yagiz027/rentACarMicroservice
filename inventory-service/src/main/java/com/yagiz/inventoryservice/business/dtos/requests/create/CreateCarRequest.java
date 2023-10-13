package com.yagiz.inventoryservice.business.dtos.requests.create;

import com.yagiz.commonservice.utils.annotations.NotFutureYear;
import com.yagiz.commonservice.utils.constants.Regex;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCarRequest {
    @NotNull
    private int modelId;

    @NotBlank
    @Pattern(regexp = Regex.Plate)
    private String plate;

    @Min(value = 1)
    private double dailyPrice;

    @Min(value = 2000)
    @NotFutureYear
    private int modelYear;
}
