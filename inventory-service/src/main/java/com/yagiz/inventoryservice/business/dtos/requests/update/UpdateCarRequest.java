package com.yagiz.inventoryservice.business.dtos.requests.update;

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
public class UpdateCarRequest {
    @NotBlank
    private String name;

    @Pattern(regexp = Regex.Plate)
    private String plate;

    @Min(value = 1)
    private double dailyPrice;

    @NotBlank
    @NotFutureYear
    private int modelYear;

    @NotNull
    private String state;

    @NotNull
    private String modelId;
}
