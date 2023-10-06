package com.yagiz.inventoryservice.business.dtos.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateModelResponse {
    private int id;
    private String name;
    private String brandName;
}
