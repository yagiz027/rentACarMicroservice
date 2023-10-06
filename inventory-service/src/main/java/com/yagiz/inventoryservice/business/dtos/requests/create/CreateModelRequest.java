package com.yagiz.inventoryservice.business.dtos.requests.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateModelRequest {
    private String name;
    private int brandId;
}
