package eu.maciejfijalkowski.lekarzWizytaPacjent.controller;

import eu.maciejfijalkowski.lekarzWizytaPacjent.model.Doctor;
import eu.maciejfijalkowski.lekarzWizytaPacjent.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

//    @Autowired
//    MedicalVisitRepository medicalVisitRepository;

    @GetMapping("/doctor")
    public String indexDoctors(ModelMap modelMap){
        modelMap.addAttribute("indexDoctors",doctorRepository.findAll());
        return"indexDoctors";
    }

    @GetMapping("/doctor/add")
    public String addDoctor(ModelMap modelMap){
        modelMap.addAttribute("doctor", new Doctor());
        return "addDoctor";
    }

    @GetMapping("/editdoctor/{id}")
    public String editDoctor(ModelMap modelMap, @PathVariable Long id){
        modelMap.addAttribute("doctor",doctorRepository.findById(id).get());
        return "editDoctor";
    }
    @PostMapping("/editdoctor")
    public String editedDoctor(@ModelAttribute Doctor doctor) {
        doctorRepository.save(doctor);
        return "redirect:/doctor";
    }

    @PostMapping ("/doctor/save")
    public String saveDoctor(@ModelAttribute Doctor doctor){
        doctorRepository.save(doctor);
        return "redirect:/doctor";
    }

//    @Transactional
//    @GetMapping("/deldoctor/{id}")
//    public String delDoctor(@PathVariable Long id){
//        medicalVisitRepository.deleteByDoctorId (id);
//        doctorRepository.deleteById(id);
//        return "redirect:/doctor";
//    }

    @GetMapping("/deldoctor/{id}")
    public String delDoctor(@PathVariable Long id,ModelMap modelMap){
        modelMap.addAttribute("id",id);
        return "delDoctor";
    }

    @DeleteMapping("/deldoctor")
    public String delDoctorComm(@ModelAttribute Doctor doctor){
        doctorRepository.deleteById(doctor.getId());
        return "redirect:/doctor";
    }

}
