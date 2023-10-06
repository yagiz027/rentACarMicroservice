package com.yagiz.inventoryservice.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.Configuration.ModelMapper.ModelMapperService;
import com.yagiz.commonservice.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.inventoryservice.business.abstracts.ModelService;
import com.yagiz.inventoryservice.business.dtos.requests.create.CreateModelRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateModelRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateModelResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetModelListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetModelResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateModelResponse;
import com.yagiz.inventoryservice.business.rules.ModelBusinessRules;
import com.yagiz.inventoryservice.entity.Model;
import com.yagiz.inventoryservice.repository.ModelRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapperService modelMapperService;
    private final ModelBusinessRules rules;

    @Override
    public CreateModelResponse add(CreateModelRequest createModelRequest) {
        Model model=modelMapperService.forRequest().map(createModelRequest, Model.class);
        repository.save(model);
        CreateModelResponse response=modelMapperService.forResponse().map(model, CreateModelResponse.class);
        return response;
    }

    @Override
    public UpdateModelResponse update(int id,UpdateModelRequest updateModelRequest) {
        rules.checkIfModelNotExists(id);
        Model model=modelMapperService.forRequest().map(updateModelRequest, Model.class);
        model.setId(id);
        repository.save(model);
        UpdateModelResponse response=modelMapperService.forResponse().map(model, UpdateModelResponse.class);
        return response;
    }

    @Override
    public GetModelResponse getModelById(int modelId) {
        Model model=repository.findById(modelId).orElseThrow(()->new BusinessException(Messages.Model.NotExists));
        GetModelResponse response=modelMapperService.forResponse().map(model, GetModelResponse.class);
        return response;
    }

    @Override
    public List<GetModelListResponse> getModelList() {
        List<GetModelListResponse> response=repository.findAll().stream()
        .map(brand-> modelMapperService.forResponse().map(brand,GetModelListResponse.class)).toList();
        return response;
    }

    @Override
    public void deleteModelById(int id) {
        rules.checkIfModelNotExists(id);
        repository.deleteById(id);
    }
}
