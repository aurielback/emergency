package com.health.registrationservice.controllerTests;

import com.health.registrationservice.constant.Sex;
import com.health.registrationservice.dto.PatientResponse;
import com.health.registrationservice.model.Patient;
import com.health.registrationservice.repository.RegistrationRepository;
import com.health.registrationservice.service.RegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RegistrationServiceTest {

    @InjectMocks
    private RegistrationService registrationService;

    @Mock
    private RegistrationRepository registrationRepository;

    @Mock
    private WebClient.Builder webClientBuilder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPatientsTest() {

        //given
        List<Patient> patientList = Arrays.asList(
                new Patient("Tomek", "Lolek", "Atomek", Sex.MALE, LocalDate.of(1996,7 ,31)),
                new Patient("Jakub", "Kromka", "Słomka", Sex.MALE, LocalDate.of(1996,7 ,31))
        );
        List<PatientResponse> patientResponseList = Arrays.asList(
                new PatientResponse("Tomek", "Lolek", "Atomek", Sex.MALE, LocalDate.of(1996,7 ,31)),
                new PatientResponse("Jakub", "Kromka", "Słomka", Sex.MALE, LocalDate.of(1996,7 ,31))
        );

        //when
        when(registrationRepository.findAll()).thenReturn(patientList);
        List<PatientResponse> result = registrationService.getAllPatients();

        //then
        assertEquals(patientResponseList, result);
        verify(registrationRepository, times(1)).findAll();
    }
}
