package com.yagiz.inventoryservice.business.dtos.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarRequest {
    private String name;
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private String state;
    private String modelId;
}
