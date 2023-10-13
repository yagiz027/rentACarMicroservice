package com.yagiz.maintenanceservice.business.rules;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.maintenanceservice.api.clients.CarClient;
import com.yagiz.maintenanceservice.repository.MaintenanceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private MaintenanceRepository repository;
    private CarClient carClient;

    public void checkIfMaintenanceNotExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Maintenance.NotExists);
        }
    }

    public void ensureCarIsAvailable(int carId){
        var response = carClient.checkCarAvailibilty(carId);
        if(!response.isSuccess()){
            throw new BusinessException(response.getMessage());
        }
    }
}
