package eu.maciejfijalkowski.lekarzWizytaPacjent.controller;

import eu.maciejfijalkowski.lekarzWizytaPacjent.model.Patient;
import eu.maciejfijalkowski.lekarzWizytaPacjent.repository.MedicalVisitRepository;
import eu.maciejfijalkowski.lekarzWizytaPacjent.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "redirect:/";
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
    public String delPatient(@PathVariable Long id){
        patientRepository.deleteById(id);
        return "redirect:/patient";
    }
}
