package com.cs.miu.hcmc.controller;

import com.cs.miu.hcmc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class myController {
    @Autowired
    PatientService patientService;
    @GetMapping({"","/Home"})
    public String showHomePage(){
        return "Home";
    }

//    @GetMapping({"","/Patients"})
//    public String displayListOfStudent(){
//        return "Patients";
//    }

    @GetMapping(value = "/Patients")
    public ModelAndView displayListOfStudent(){
        var patients = patientService.getAllPatient();
        var modelAndView =new ModelAndView();
        modelAndView.addObject("patients", patients);
        modelAndView.setViewName("Patients");
        return modelAndView;
    }
    @GetMapping(value = "/ElderlyPatients")
    public ModelAndView displayListOfElderly(){
        var elderlypatients = patientService.getElderlyPatient();
        var modelAndView =new ModelAndView();
        modelAndView.addObject("elderlypatients", elderlypatients);
        modelAndView.setViewName("elderlypatients");
        return modelAndView;
    }
}
