package com.yagiz.maintenanceservice.business.dtos.requests;

import java.time.LocalDateTime;

import com.yagiz.commonservice.utils.annotations.NotFutureYear;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateMaintenanceRequest {
    private int id;
    @NotNull
    private int carId;

    @NotNull
    private String information;

    @NotNull
    @NotFutureYear
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;
}
