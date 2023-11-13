package com.health.registrationservice.tools;

import com.health.registrationservice.dto.PatientRequest;
import com.health.registrationservice.dto.PatientResponse;
import com.health.registrationservice.model.Patient;
import org.mapstruct.Mapper;

@Mapper
public interface PatientMapper {

    Patient patientRequestToPatient(PatientRequest patientRequest);
    PatientRequest patientToPatientRequest(Patient patient);

    Patient patientResponseToPatient(PatientResponse patientResponse);
    PatientResponse patientToPatientResponse(Patient patient);
}
