package com.yagiz.maintenanceservice.business.rules;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.maintenanceservice.repository.MaintenanceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private MaintenanceRepository repository;

    public void checkIfMaintenanceNotExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Maintenance.NotExists);
        }
    }
}
