package com.Corona.rate.demo.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    dataServiceLayer dataservice;

    @GetMapping("/")
    public String index(Model model){
        return "index.html";
    }

    @GetMapping("/confirmed")
    public String confirmed(Model model){
        model.addAttribute("coronaStats",dataservice.getCoronaData());
        model.addAttribute("totalCases",dataservice.getTotalCases());
        return "CoronaVirusDisplay.html";
    }

    @GetMapping("/death")
    public String death(Model model){
        model.addAttribute("deathStats",dataservice.getDeathdata());
        model.addAttribute("totalDeath",dataservice.getTotaldeathCases());
        return "CoronaVirusDeathDisplay.html";
    }

    @GetMapping("/Search")
    public  String search(Model model){
        return "https://covid19.who.int/region/afro/country/td";
    }
}
