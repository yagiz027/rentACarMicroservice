package com.yagiz.invoiceservice.business.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.Events.RentalPaymentEvent.CreateRentalPaymentEvent;
import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;
import com.yagiz.invoiceservice.business.abstracts.InvoiceService;
import com.yagiz.invoiceservice.entity.Invoice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class RentalPaymentConsumer {
    private final ModelMapperService mapperService;
    private final InvoiceService service;

    @KafkaListener(
        topics = "rental-payment-event-created",
        groupId = "invoice-rental-payment"
    )
    public void consume(CreateRentalPaymentEvent event){
        var invoice = mapperService.forRequest().map(event, Invoice.class);
        service.add(invoice);
        log.info("Rental payment event created and events consumed {}", event);
    }
}
