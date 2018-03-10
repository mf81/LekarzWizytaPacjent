package eu.maciejfijalkowski.lekarzWizytaPacjent.controller;

import eu.maciejfijalkowski.lekarzWizytaPacjent.model.Doctor;
import eu.maciejfijalkowski.lekarzWizytaPacjent.model.Patient;
import eu.maciejfijalkowski.lekarzWizytaPacjent.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

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
        return "redirect:/";
    }

    @GetMapping("/deldoctor/{id}")
    public String delDoctor(@PathVariable Long id){
        doctorRepository.deleteById(id);
        return "redirect:/doctor";
    }

}
