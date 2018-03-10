package eu.maciejfijalkowski.lekarzWizytaPacjent.controller;

import eu.maciejfijalkowski.lekarzWizytaPacjent.model.MedicalVisit;
import eu.maciejfijalkowski.lekarzWizytaPacjent.repository.DoctorRepository;
import eu.maciejfijalkowski.lekarzWizytaPacjent.repository.MedicalVisitRepository;
import eu.maciejfijalkowski.lekarzWizytaPacjent.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class VisitController {

    @Autowired
    MedicalVisitRepository medicalVisitRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    MedicalVisit medicalVisit = new MedicalVisit();

    @GetMapping("/visit")
    public String indexVisits(ModelMap modelMap){
        modelMap.addAttribute("indexVisits",medicalVisitRepository.findAll());
        return"indexVisits";
    }

    @GetMapping("/visit/add")
    public String addVisit(ModelMap modelMap){
        modelMap.addAttribute("patient",patientRepository.findAll());
        modelMap.addAttribute("doctor",doctorRepository.findAll());
        modelMap.addAttribute("medicalVisit",medicalVisit);
        return "addVisit";
    }

    @PostMapping("/visit/save")
    public String saveVisit(@ModelAttribute MedicalVisit medicalVisit){
        medicalVisitRepository.save(medicalVisit);
        return "redirect:/";
    }

    @GetMapping("/delvisit/{id}")
    public String delVisit(@PathVariable Long id){
        medicalVisitRepository.deleteById(id);
        return "redirect:/visit";
    }


//    @PostMapping("/visit/save")
//    public String saveVisit(){
//        return "redirect:/";
//    }

}