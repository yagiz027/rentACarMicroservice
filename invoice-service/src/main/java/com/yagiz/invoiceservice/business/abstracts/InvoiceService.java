package com.yagiz.invoiceservice.business.abstracts;

import java.util.List;

import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceListResponse;
import com.yagiz.invoiceservice.business.dtos.responses.get.GetInvoiceResponse;
import com.yagiz.invoiceservice.entity.Invoice;

public interface InvoiceService {
    void add(Invoice invoice);
    List<GetInvoiceListResponse> getInvoiceList();
    GetInvoiceResponse getInvoiceById(String id);
}
