package com.yagiz.maintenanceservice.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yagiz.commonservice.utils.Kafka.KafkaProducer;
import com.yagiz.commonservice.utils.Kafka.Events.Maintenance.MaintenanceCreateEvent;
import com.yagiz.commonservice.utils.Kafka.Events.Maintenance.MaintenanceDeleteEvent;
import com.yagiz.commonservice.utils.ModelMapper.ModelMapperService;
import com.yagiz.commonservice.utils.RestExceptionHandler.constants.Messages;
import com.yagiz.commonservice.utils.RestExceptionHandler.exceptions.BusinessException;
import com.yagiz.maintenanceservice.business.abstracts.MaintenanceService;
import com.yagiz.maintenanceservice.business.dtos.requests.CreateMaintenanceRequest;
import com.yagiz.maintenanceservice.business.dtos.requests.UpdateMaintenanceRequest;
import com.yagiz.maintenanceservice.business.dtos.responses.CreateMaintenanceResponse;
import com.yagiz.maintenanceservice.business.dtos.responses.UpdateMaintenanceResponse;
import com.yagiz.maintenanceservice.business.dtos.responses.get.GetMaintenance;
import com.yagiz.maintenanceservice.business.dtos.responses.get.GetMaintenanceList;
import com.yagiz.maintenanceservice.business.rules.MaintenanceBusinessRules;
import com.yagiz.maintenanceservice.entity.Maintenance;
import com.yagiz.maintenanceservice.repository.MaintenanceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MaintenanceManager implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final ModelMapperService modelMapperService;
    private final MaintenanceBusinessRules rules;
    private final KafkaProducer producer;

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        rules.ensureCarIsAvailable(request.getCarId());
        Maintenance maintenance = modelMapperService.forRequest().map(request, Maintenance.class);
        maintenance.setId(0);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDateTime(null);
        repository.save(maintenance);

        CreateMaintenanceResponse response = modelMapperService.forResponse().map(maintenance,
                CreateMaintenanceResponse.class);
        sendKafkaMaintenanceCreatedEvent(request.getCarId());
        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        rules.checkIfMaintenanceNotExists(id);
        boolean isEqual = false;
        int olderCarId = repository.findById(id).orElseThrow().getCarId();

        Maintenance maintenance = modelMapperService.forRequest().map(request, Maintenance.class);
        maintenance.setId(id);
        repository.save(maintenance);

        isEqual = request.getCarId() == olderCarId ? true : false;

        if (isEqual == false) {
            sendKafkaMaintenanceCreatedEvent(request.getCarId());
        }

        UpdateMaintenanceResponse response = modelMapperService.forResponse().map(maintenance,
                UpdateMaintenanceResponse.class);
        return response;
    }

    @Override
    public GetMaintenance getMaintenanceById(int id) {
        Maintenance maintenance = repository.findById(id)
                .orElseThrow(() -> new BusinessException(Messages.Maintenance.NotExists));
        GetMaintenance respone = modelMapperService.forResponse().map(maintenance, GetMaintenance.class);

        return respone;
    }

    @Override
    public List<GetMaintenanceList> getMaintenanceList() {
        List<GetMaintenanceList> maintenanceList = repository.findAll().stream()
                .map(maintenance -> modelMapperService.forResponse().map(maintenance, GetMaintenanceList.class))
                .toList();
        return maintenanceList;
    }

    @Override
    public void deleteById(int id) {
        rules.checkIfMaintenanceNotExists(id);
        repository.deleteById(id);
        sendKafkaMaintenanceDeletedEvent(id);
    }

    private void sendKafkaMaintenanceDeletedEvent(int id) {
        var carId = repository.findById(id).orElseThrow().getCarId(); // Find the carId by given maintenance id
        producer.sendMessage(new MaintenanceDeleteEvent(carId), "maintenance-deleted");
    }

    private void sendKafkaMaintenanceCreatedEvent(int carId) {
        producer.sendMessage(new MaintenanceCreateEvent(carId), "maintenance-created");
    }
}
