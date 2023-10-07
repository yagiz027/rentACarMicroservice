package com.yagiz.inventoryservice.business.rules;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.inventoryservice.repository.ModelRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelBusinessRules {
    private final ModelRepository repository;

    public void checkIfModelNotExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Model.NotExists);
        }
    }
}
