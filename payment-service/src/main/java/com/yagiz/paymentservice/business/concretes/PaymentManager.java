package com.yagiz.paymentservice.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.KafkaProducer;
import com.yagiz.commonservice.utils.Kafka.Events.Payment.PaymentCreateEvent;
import com.yagiz.commonservice.utils.Kafka.Events.Payment.PaymentDeletedEvent;
import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;
import com.yagiz.paymentservice.adapter.FakePosAdapter;
import com.yagiz.paymentservice.business.abstracts.PaymentService;
import com.yagiz.paymentservice.business.dtos.requests.CreatePaymentRequest;
import com.yagiz.paymentservice.business.dtos.requests.UpdatePaymentRequest;
import com.yagiz.paymentservice.business.dtos.responses.CreatePaymentResponse;
import com.yagiz.paymentservice.business.dtos.responses.UpdatePaymentResponse;
import com.yagiz.paymentservice.business.dtos.responses.get.GetPaymentListResponse;
import com.yagiz.paymentservice.business.dtos.responses.get.GetPaymentResponse;
import com.yagiz.paymentservice.business.rules.PaymentBusinessRules;
import com.yagiz.paymentservice.entity.Payment;
import com.yagiz.paymentservice.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapperService mapperService;
    private final PaymentBusinessRules rules;
    private final KafkaProducer producer;
    private final FakePosAdapter adapter;

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        rules.checkIfPaymentAlreadyExists(request.getCardNumber()); 
        Payment payment = mapperService.forRequest().map(request, Payment.class);
        payment.setId(0);

        //Fake paying 
        rules.checkIfPaymentExpirationDateExpired(payment.getCardExpirationYear(),payment.getCardExpirationMonth());
        adapter.pay();
        var createEvent = repository.save(payment);
        CreatePaymentResponse response = mapperService.forResponse().map(payment, CreatePaymentResponse.class);
        sendPaymentCreateEventToKafka(createEvent);
        return response;
    }
    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request) {
        rules.checkIfPaymentNotExists(id);
        Payment payment = mapperService.forRequest().map(request, Payment.class);
        payment.setId(id); 
        
        rules.checkIfPaymentExpirationDateExpired(payment.getCardExpirationYear(),payment.getCardExpirationMonth());
        adapter.pay();
        repository.save(payment);
        UpdatePaymentResponse response = mapperService.forRequest().map(payment, UpdatePaymentResponse.class);
        return response;
    }
    @Override
    public GetPaymentResponse getPaymentById(int id) {
        rules.checkIfPaymentNotExists(id);
        Payment payment = repository.findById(id).orElseThrow();
        GetPaymentResponse response = mapperService.forResponse().map(payment, GetPaymentResponse.class);

        return response;
    }
    @Override
    public List<GetPaymentListResponse> getPaymentList() {
        List<GetPaymentListResponse> responseList = repository.findAll().stream()
        .map(payment -> mapperService.forResponse().map(payment, GetPaymentListResponse.class)).toList();
        
        return responseList;
    }
    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
        sendDeletedPaymentEventToKafka(id);
    }

    private void sendDeletedPaymentEventToKafka(int id) {
        producer.sendMessage(new PaymentDeletedEvent(id), "payment-deleted");
    }

    private void sendPaymentCreateEventToKafka(Payment payment){
        var event = mapperService.forResponse().map(payment, PaymentCreateEvent.class);
        producer.sendMessage(event, "payment-created");
    }
}
