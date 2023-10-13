package com.yagiz.inventoryservice.business.dtos.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarResponse {
    private int id;
    private String plate;
    private double dailyPrice;
    private int modelYear;
    private String state;
    private String modelName;
}
