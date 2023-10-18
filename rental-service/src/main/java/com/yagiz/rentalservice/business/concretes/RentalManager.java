package com.yagiz.rentalservice.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.KafkaProducer;
import com.yagiz.commonservice.utils.Kafka.Events.Rental.RentalCreateEvent;
import com.yagiz.commonservice.utils.Kafka.Events.Rental.RentalDeleteEvent;
import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;
import com.yagiz.rentalservice.business.abstracts.RentalService;
import com.yagiz.rentalservice.business.dtos.requests.CreateRentalRequest;
import com.yagiz.rentalservice.business.dtos.requests.UpdateRentalRequests;
import com.yagiz.rentalservice.business.dtos.responses.CreateRentalResponses;
import com.yagiz.rentalservice.business.dtos.responses.UpdateRentalResponses;
import com.yagiz.rentalservice.business.dtos.responses.get.GetRentalListResponses;
import com.yagiz.rentalservice.business.dtos.responses.get.GetRentalResponses;
import com.yagiz.rentalservice.business.rules.RentalBusinessRules;
import com.yagiz.rentalservice.entity.Rental;
import com.yagiz.rentalservice.repository.RentalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalManager implements RentalService{
    private final RentalRepository rentalRepository;
    private final ModelMapperService mapperService;
    private final RentalBusinessRules rules;
    private final KafkaProducer producer;
    
    @Override
    public CreateRentalResponses add(CreateRentalRequest createRentalRequest) {
        Rental rental=mapperService.forRequest().map(createRentalRequest, Rental.class);
        rental.setId(0);
        rental.setRentedAt(LocalDate.now());

        var createdRental = rentalRepository.save(rental);
        CreateRentalResponses rentalResponses=mapperService.forResponse().map(rental, CreateRentalResponses.class);
        sendKafkaRentalCreateEvent(createdRental);
        return rentalResponses;
    }

    @Override
    public UpdateRentalResponses update(int id,UpdateRentalRequests updateRentalRequest) {
        rules.checkIfRentalExists(id);
        Rental rental = mapperService.forRequest().map(updateRentalRequest, Rental.class);
        rental.setId(id);
        rental.setRentedAt(LocalDate.now());
        
        rentalRepository.save(rental);

        UpdateRentalResponses rentalResponse = mapperService.forResponse().map(rental, UpdateRentalResponses.class);

        return rentalResponse;
    }

    @Override
    public GetRentalResponses getRentalById(int id) {   
        rules.checkIfRentalExists(id);
        Rental rental= rentalRepository.findById(id).orElseThrow();
        GetRentalResponses response = mapperService.forResponse().map(rental, GetRentalResponses.class);
        return response;
    }

    @Override
    public List<GetRentalListResponses> getRentalList() {
        List<GetRentalListResponses> responses = rentalRepository.findAll()
        .stream().map(rental-> mapperService.forResponse().map(rental, GetRentalListResponses.class)).toList();
        return responses;
    }

    @Override
    public void deleteById(int id) {
        rules.checkIfRentalExists(id);
        rentalRepository.deleteById(id);
        sendKafkaRentalDeleteEvent(id);
    }

    private void sendKafkaRentalCreateEvent(Rental createdRental){
        var createRentalEvent = mapperService.forResponse().map(createdRental,RentalCreateEvent.class);
        producer.sendMessage(createRentalEvent, "rental-created");
    }

    private void sendKafkaRentalDeleteEvent(int id){
        producer.sendMessage(new RentalDeleteEvent(id), "rental-deleted");
    }
}
