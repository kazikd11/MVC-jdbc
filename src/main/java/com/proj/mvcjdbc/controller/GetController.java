package com.proj.mvcjdbc.controller;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.model.Shelter;
import com.proj.mvcjdbc.service.PointsGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GetController {

    final PointsGetService pointsGetService;

    @Autowired
    public GetController(PointsGetService pointsGetService) {
        this.pointsGetService = pointsGetService;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/adminPage")
    public String showAdminPage() {
        return "admin_page";
    }

    @GetMapping("/showPeaks")
    public String showPeaks(Model model) {
        List<Peak> dataList = pointsGetService.getPeaks();
        model.addAttribute("dataList", dataList);
//        System.out.println("Data list: " + dataList);
        return "show_peaks";
    }

    @GetMapping("/showShelters")
    public String showShelters(Model model) {
        List<Shelter> dataList;
        if (false) { //tbd
            dataList = pointsGetService.getAdminShelters();
        } else {
            dataList = pointsGetService.getUserShelters();
        }
        model.addAttribute("shelters", dataList);
        return "show_shelters";
    }

}