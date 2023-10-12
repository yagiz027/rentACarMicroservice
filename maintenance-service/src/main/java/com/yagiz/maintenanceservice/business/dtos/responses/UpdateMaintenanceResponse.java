package com.yagiz.maintenanceservice.business.dtos.responses;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateMaintenanceResponse {
    private int id;
    private int carId;
    private String information;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
