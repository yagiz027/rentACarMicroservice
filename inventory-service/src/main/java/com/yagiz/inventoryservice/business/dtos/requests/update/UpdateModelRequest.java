package com.yagiz.inventoryservice.business.dtos.requests.update;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateModelRequest {
    @NotNull
    private int id;

    @Size(min = 2, max = 20)
    @NotNull
    private String name;

    @NotNull
    private int brandId;
}
