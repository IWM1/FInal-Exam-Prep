package com.cs.miu.hcmc.service.Imp;

import com.cs.miu.hcmc.model.Patient;
import com.cs.miu.hcmc.repository.PatientRepository;
import com.cs.miu.hcmc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImp implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll(Sort.by(Sort.Direction.ASC,"fullNames"));
    }

    @Override
    public List<Patient> getElderlyPatient() {
        return patientRepository.findAll().stream().
                filter(Patient -> Patient.getDateOfBirth().
                        isBefore(LocalDate.of(1957, Month.JANUARY, 1))).
                collect(Collectors.toList());
    }
}
