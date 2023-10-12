package com.yagiz.maintenanceservice.business.abstracts;

import java.util.List;

import com.yagiz.maintenanceservice.business.dtos.requests.CreateMaintenanceRequest;
import com.yagiz.maintenanceservice.business.dtos.requests.UpdateMaintenanceRequest;
import com.yagiz.maintenanceservice.business.dtos.responses.CreateMaintenanceResponse;
import com.yagiz.maintenanceservice.business.dtos.responses.UpdateMaintenanceResponse;
import com.yagiz.maintenanceservice.business.dtos.responses.get.GetMaintenance;
import com.yagiz.maintenanceservice.business.dtos.responses.get.GetMaintenanceList;

public interface MaintenanceService {
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id,UpdateMaintenanceRequest request); 
    GetMaintenance getMaintenanceById(int id);
    List<GetMaintenanceList> getMaintenanceList();
    void deleteById(int id);
}
