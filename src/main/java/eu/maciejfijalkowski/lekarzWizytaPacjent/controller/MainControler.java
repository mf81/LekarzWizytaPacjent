package eu.maciejfijalkowski.lekarzWizytaPacjent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControler {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
