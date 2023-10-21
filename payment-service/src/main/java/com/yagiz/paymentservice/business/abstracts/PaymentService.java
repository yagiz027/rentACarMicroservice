package com.yagiz.paymentservice.business.abstracts;

import java.util.List;

import com.yagiz.commonservice.utils.dto.ClientResponse;
import com.yagiz.commonservice.utils.dto.CreateRentalPaymentRequest;
import com.yagiz.paymentservice.business.dtos.requests.CreatePaymentRequest;
import com.yagiz.paymentservice.business.dtos.requests.UpdatePaymentRequest;
import com.yagiz.paymentservice.business.dtos.responses.CreatePaymentResponse;
import com.yagiz.paymentservice.business.dtos.responses.UpdatePaymentResponse;
import com.yagiz.paymentservice.business.dtos.responses.get.GetPaymentListResponse;
import com.yagiz.paymentservice.business.dtos.responses.get.GetPaymentResponse;

public interface PaymentService {
    CreatePaymentResponse add(CreatePaymentRequest request);
    UpdatePaymentResponse update(int id, UpdatePaymentRequest response);
    GetPaymentResponse getPaymentById(int id);
    List<GetPaymentListResponse> getPaymentList();
    void deleteById(int id);
    ClientResponse paymentProcessForRental(CreateRentalPaymentRequest rentalPaymentRequest);
}
