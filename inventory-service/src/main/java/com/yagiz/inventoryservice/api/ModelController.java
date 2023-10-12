package com.yagiz.inventoryservice.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.yagiz.inventoryservice.business.abstracts.ModelService;
import com.yagiz.inventoryservice.business.dtos.requests.create.CreateModelRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateModelRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateModelResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetModelListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetModelResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateModelResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/models")
public class ModelController {
    private final ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreateModelResponse add(CreateModelRequest request){
        return modelService.add(request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest request){
        return modelService.update(id,request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetModelResponse getModelById(@PathVariable int id){
        return modelService.getModelById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetModelListResponse> getModelList(){
        return modelService.getModelList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModelById(@PathVariable int id){
        modelService.deleteModelById(id);
    }
}
