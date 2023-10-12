package com.yagiz.maintenanceservice.business.dtos.responses.get;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetMaintenanceList {
    private int id;
    private int carId;
    private String information;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
