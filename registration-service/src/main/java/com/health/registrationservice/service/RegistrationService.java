package com.health.registrationservice.service;

import com.health.registrationservice.dto.HospitalWithAvailableCapacity;
import com.health.registrationservice.dto.PatientRequest;
import com.health.registrationservice.dto.PatientResponse;
import com.health.registrationservice.event.PatientRegistrationEvent;
import com.health.registrationservice.model.Patient;
import com.health.registrationservice.repository.RegistrationRepository;
import com.health.registrationservice.tools.PatientMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final WebClient.Builder webClientBuilder;
    private final PatientMapper patientMapper = Mappers.getMapper(PatientMapper.class);
    private final KafkaTemplate<String, PatientRegistrationEvent> kafkaTemplate;

    public RegistrationService(RegistrationRepository registrationRepository,
                               WebClient.Builder webClientBuilder,
                               KafkaTemplate kafkaTemplate) {
        this.registrationRepository = registrationRepository;
        this.webClientBuilder = webClientBuilder;
        this.kafkaTemplate = kafkaTemplate;
    }

    public String registerClient(PatientRequest patientRequest) {
        Patient patient = patientMapper.patientRequestToPatient(patientRequest);

        HospitalWithAvailableCapacity[] hospital = webClientBuilder.build().get().
                //TODO "http://hospital-service/api/hospital
                uri("http://localhost:8081/api/hospital")
                        .retrieve()
                                .bodyToMono(HospitalWithAvailableCapacity[].class)
                                        .block();

        assert hospital != null;
        boolean isFreeSpace = Arrays.stream(hospital).anyMatch(hospitalWithAvailableCapacity -> hospitalWithAvailableCapacity
                .getAvailableCapacity() > 0);

        if (isFreeSpace) {
            registrationRepository.save(patient);
            kafkaTemplate.send("notificationTopic", new PatientRegistrationEvent(patient.getFirstName()));
            return "Registered!";
        }
        else {
            throw new IllegalArgumentException("There is no free space in hospitals!");
        }
    }

    public List<PatientResponse> getAllPatients() {
        return registrationRepository.findAll().stream()
                .map(patientMapper::patientToPatientResponse).toList();
    }
}
