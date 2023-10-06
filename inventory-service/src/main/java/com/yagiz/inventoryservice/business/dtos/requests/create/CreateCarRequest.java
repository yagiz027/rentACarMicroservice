package com.yagiz.inventoryservice.business.dtos.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCarRequest {
    private String name;
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private String state;
    private int modelId;
}
