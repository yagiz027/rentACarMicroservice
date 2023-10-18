package com.yagiz.rentalservice.business.abstracts;

import java.util.List;

import com.yagiz.rentalservice.business.dtos.requests.CreateRentalRequest;
import com.yagiz.rentalservice.business.dtos.requests.UpdateRentalRequests;
import com.yagiz.rentalservice.business.dtos.responses.CreateRentalResponses;
import com.yagiz.rentalservice.business.dtos.responses.UpdateRentalResponses;
import com.yagiz.rentalservice.business.dtos.responses.get.GetRentalListResponses;
import com.yagiz.rentalservice.business.dtos.responses.get.GetRentalResponses;

public interface RentalService {
    CreateRentalResponses add(CreateRentalRequest createRentalRequest);
    UpdateRentalResponses update(int id,UpdateRentalRequests updateRentalRequest);
    GetRentalResponses getRentalById(int id);
    List<GetRentalListResponses> getRentalList();
    void deleteById(int id);
}
