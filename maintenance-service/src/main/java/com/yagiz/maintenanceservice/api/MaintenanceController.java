package com.yagiz.maintenanceservice.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yagiz.maintenanceservice.business.abstracts.MaintenanceService;
import com.yagiz.maintenanceservice.business.dtos.requests.CreateMaintenanceRequest;
import com.yagiz.maintenanceservice.business.dtos.requests.UpdateMaintenanceRequest;
import com.yagiz.maintenanceservice.business.dtos.responses.CreateMaintenanceResponse;
import com.yagiz.maintenanceservice.business.dtos.responses.UpdateMaintenanceResponse;
import com.yagiz.maintenanceservice.business.dtos.responses.get.GetMaintenance;
import com.yagiz.maintenanceservice.business.dtos.responses.get.GetMaintenanceList;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED) 
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request){
        return maintenanceService.add(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UpdateMaintenanceResponse update(@PathVariable int id, UpdateMaintenanceRequest request){
        return maintenanceService.update(id, request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public GetMaintenance getMaintenanceById(@PathVariable int id){
        return maintenanceService.getMaintenanceById(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<GetMaintenanceList> getMaintenanceList(){
        return maintenanceService.getMaintenanceList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        maintenanceService.deleteById(id);
    }
}
