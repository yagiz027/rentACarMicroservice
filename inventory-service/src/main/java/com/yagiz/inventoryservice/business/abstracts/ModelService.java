package com.yagiz.inventoryservice.business.abstracts;

import com.yagiz.inventoryservice.business.dtos.requests.create.CreateModelRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateModelRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateModelResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetModelListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetModelResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateModelResponse;

import java.util.List;

public interface ModelService {
    CreateModelResponse add(CreateModelRequest createModelRequest);
    UpdateModelResponse update(int id,UpdateModelRequest updateModelRequest);
    GetModelResponse getModelById(int modelId);
    List<GetModelListResponse> getModelList();
    void deleteModelById(int id);
}
