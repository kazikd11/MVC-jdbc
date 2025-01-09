package com.proj.mvcjdbc.controller;

import com.proj.mvcjdbc.model.Peak;
import com.proj.mvcjdbc.model.Point;
import com.proj.mvcjdbc.model.PointTime;
import com.proj.mvcjdbc.model.Shelter;
import com.proj.mvcjdbc.service.PointsGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        dataList = pointsGetService.getUserShelters();
        model.addAttribute("shelters", dataList);
        return "show_shelters";
    }

    @GetMapping("/findPath")
    public String findPath(@RequestParam int id1, @RequestParam int id2, Model model) {
        List<PointTime> path = pointsGetService.getPath(id1, id2);
        System.out.println("Path: " + path);
        model.addAttribute("path",path);
        return "path";
    }

}