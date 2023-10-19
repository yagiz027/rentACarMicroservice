package com.yagiz.commonservice.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarClientResponse extends ClientResponse {
    private String modelName;
    private String brandName;
    private String carName;
    private String plate;
    private int modelYear;
    private double dailyPrice;
}
