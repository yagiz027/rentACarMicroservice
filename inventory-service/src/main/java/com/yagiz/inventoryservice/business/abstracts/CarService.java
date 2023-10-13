package com.yagiz.inventoryservice.business.abstracts;

import com.yagiz.commonservice.utils.dto.ClientResponse;
import com.yagiz.inventoryservice.business.dtos.requests.create.CreateCarRequest;
import com.yagiz.inventoryservice.business.dtos.requests.update.UpdateCarRequest;
import com.yagiz.inventoryservice.business.dtos.responses.create.CreateCarResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetCarListResponse;
import com.yagiz.inventoryservice.business.dtos.responses.get.GetCarResponse;
import com.yagiz.inventoryservice.business.dtos.responses.update.UpdateCarResponse;
import com.yagiz.inventoryservice.entity.enums.State;

import java.util.List;

public interface CarService {
    CreateCarResponse add(CreateCarRequest createCarRequest);
    UpdateCarResponse upate(int id, UpdateCarRequest updateCarRequest);
    GetCarResponse getCarById(int id);
    List<GetCarListResponse> getCarList();
    void deleteCarById(int id);
    ClientResponse checkCarAvailabilty(int id);
    void changeStateByCarId(State state, int id);
}
