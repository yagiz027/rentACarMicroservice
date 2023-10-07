package com.yagiz.inventoryservice.business.rules;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages.Brand;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.inventoryservice.repository.BrandRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BrandBusinessRules {
    private final BrandRepository repository;

    public void ifBrandNotExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Brand.NotExists);
        }
    }
}
