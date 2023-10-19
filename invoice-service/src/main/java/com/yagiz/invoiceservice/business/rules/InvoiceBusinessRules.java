package com.yagiz.invoiceservice.business.rules;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.invoiceservice.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvoiceBusinessRules {
    private final InvoiceRepository repository;

    public void checkIfInvoiceNotExists(String id) {
        if(!repository.existsById(id)){
            throw new BusinessException(Messages.Invoice.NotExists);
        }
    }
}
