package com.yagiz.invoiceservice.business.abstracts;

import java.util.List;

import com.yagiz.invoiceservice.business.dtos.requests.CreateInvoiceRequest;
import com.yagiz.invoiceservice.business.dtos.requests.UpdateInvoiceRequest;
import com.yagiz.invoiceservice.business.dtos.responses.CreateInvoiceResponse;
import com.yagiz.invoiceservice.business.dtos.responses.UpdateInvoiceResponse;
import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceListResponse;
import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceResponse;

public interface InvoiceService {
    CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest);
    UpdateInvoiceResponse update(int id,UpdateInvoiceRequest updateInvoiceRequest);
    List<GetInvoiceListResponse> getInvoiceList();
    GetInvoiceResponse getInvoiceById(int id);
    void deleteById(int id);
}
