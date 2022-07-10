package com.cs.miu.hcmc.service;

import com.cs.miu.hcmc.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    public abstract List<Patient> getAllPatient ();
    public abstract List<Patient> getElderlyPatient ();
}
