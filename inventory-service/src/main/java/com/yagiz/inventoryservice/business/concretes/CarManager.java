package com.yagiz.inventoryservice.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.Configuration.ModelMapper.ModelMapperService;
import com.yagiz.inventoryservice.business.abstracts.CarService;
import com.yagiz.inventoryservice.business.dtos.requests.create.CreateCarRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateCarRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateCarResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetCarListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetCarResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateCarResponse;
import com.yagiz.inventoryservice.business.rules.CarBusinessRules;
import com.yagiz.inventoryservice.entity.Car;
import com.yagiz.inventoryservice.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository repository;
    private final ModelMapperService modelMapperService;
    private final CarBusinessRules rules;

    @Override
    public CreateCarResponse add(CreateCarRequest createCarResponse) {
        Car car=modelMapperService.forRequest().map(createCarResponse, Car.class);
        repository.save(car);
        CreateCarResponse response=modelMapperService.forResponse().map(car, CreateCarResponse.class);
        return response;
    }

    @Override
    public UpdateCarResponse upate(int id, UpdateCarRequest updateCarRequest) {
        Car car = modelMapperService.forRequest().map(updateCarRequest, Car.class);
        car.setId(id);
        repository.save(car);
        UpdateCarResponse response=modelMapperService.forResponse().map(car, UpdateCarResponse.class);
        return response;
    }

    @Override
    public GetCarResponse getCarById(int id) {
        Car car= repository.findById(id).orElseThrow();
        GetCarResponse response=modelMapperService.forResponse().map(car,GetCarResponse.class);
        return response;
    }

    @Override
    public List<GetCarListResponse> getCarList() {
        List<GetCarListResponse> response = repository.findAll()
        .stream().map(brand-> modelMapperService.forRequest()
        .map(brand, GetCarListResponse.class)).toList();

        return response;
    }

    @Override
    public void deleteCarById(int id) {
        rules.checkIfCarNotExists(id);
        repository.deleteById(id);
    }
}