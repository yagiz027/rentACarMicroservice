package com.yagiz.maintenanceservice.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;
import com.yagiz.maintenanceservice.business.abstracts.MaintenanceService;
import com.yagiz.maintenanceservice.business.dtos.requests.CreateMaintenanceRequest;
import com.yagiz.maintenanceservice.business.dtos.requests.UpdateMaintenanceRequest;
import com.yagiz.maintenanceservice.business.dtos.responses.CreateMaintenanceResponse;
import com.yagiz.maintenanceservice.business.dtos.responses.UpdateMaintenanceResponse;
import com.yagiz.maintenanceservice.business.dtos.responses.get.GetMaintenance;
import com.yagiz.maintenanceservice.business.dtos.responses.get.GetMaintenanceList;
import com.yagiz.maintenanceservice.business.rules.MaintenanceBusinessRules;
import com.yagiz.maintenanceservice.entity.Maintenance;
import com.yagiz.maintenanceservice.repository.MaintenanceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final ModelMapperService modelMapperService;
    private final MaintenanceBusinessRules rules;

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        Maintenance maintenance=modelMapperService.forRequest().map(request,Maintenance.class);
        maintenance.setId(0);

        repository.save(maintenance);
        CreateMaintenanceResponse response=modelMapperService.forResponse().map(maintenance,CreateMaintenanceResponse.class);
        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id,UpdateMaintenanceRequest request) { 
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public GetMaintenance getMaintenanceById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaintenanceById'");
    }

    @Override
    public List<GetMaintenanceList> getMaintenanceList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMaintenanceList'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
