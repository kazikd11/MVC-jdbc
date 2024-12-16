package com.proj.mvcjdbc.controller;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.model.Shelter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.proj.mvcjdbc.service.GetPoints.getPeaks;
import static com.proj.mvcjdbc.service.GetPoints.getShelters;

@Controller
public class MainController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/addData")
    public String showAddDataForm() {
        return "add_data";
    }

    @GetMapping("/showPeaks")
    public String showPeaks(Model model) {
        List<Peak> dataList = getPeaks();
        model.addAttribute("dataList", dataList);
        System.out.println("Data list: " + dataList);
        return "show_peaks";
    }

    @GetMapping("/showShelters")
    public String showShelters(Model model) {
        List<Shelter> dataList = getShelters();
        model.addAttribute("dataList", dataList);
        System.out.println("Data list: " + dataList);
        return "show_shelters";
    }

}