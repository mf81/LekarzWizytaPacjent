package eu.maciejfijalkowski.lekarzWizytaPacjent.controller;

import eu.maciejfijalkowski.lekarzWizytaPacjent.model.Patient;
import eu.maciejfijalkowski.lekarzWizytaPacjent.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patient")
    public String indexPatient(ModelMap modelMap){
        modelMap.addAttribute("indexPatients",patientRepository.findAll());
        return"indexPatients";
    }

    @GetMapping("/patient/add")
    public String addPatient(ModelMap modelMap){
        modelMap.addAttribute("patient",new Patient());
        return "addPatient";
    }

    @PostMapping("/patient/save")
    public String savePatient(@ModelAttribute Patient patient){
        patientRepository.save(patient);
        return "redirect:/patient";
    }

    @GetMapping("/editpatient/{id}")
    public String editPatient(ModelMap modelMap, @PathVariable Long id){
        modelMap.addAttribute("patient",patientRepository.findById(id).get());
        return "editPatient";
    }
    @PostMapping("/editpatient")
    public String editedPatient(@ModelAttribute Patient patient){
        patientRepository.save(patient);
        return "redirect:/patient";
    }

    @GetMapping("/delpatient/{id}")
    public String delPatient(@PathVariable Long id,ModelMap modelMap){
        modelMap.addAttribute("id",id);
        return "delPatient";
    }

    @DeleteMapping("/delpatient")
    public String delPatientComm(@ModelAttribute Patient patient){
        patientRepository.deleteById(patient.getId());
        return "redirect:/patient";
    }
}
