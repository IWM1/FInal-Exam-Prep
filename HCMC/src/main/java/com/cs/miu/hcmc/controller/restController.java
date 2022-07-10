package com.cs.miu.hcmc.controller;

import com.cs.miu.hcmc.model.Patient;
import com.cs.miu.hcmc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myapi")
public class restController {
    @Autowired
    private PatientService patientService;
    @GetMapping(value = "/list")
    public List<Patient> myAPis(){
        return patientService.getAllPatient();
    }
}

