package com.proj.mvcjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Arrays;

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

    @GetMapping("/showData")
    public String showDataPage(Model model) {
        List<Data> dataList = getData();
        model.addAttribute("dataList", dataList);
        return "show_data";
    }

    private List<Data> getData() {
        return Arrays.asList(
                new Data(1, "Giewont", 1894),
                new Data(2, "Rysy", 2499)
        );
    }

    public record Data(int id, String name, int height) {}

}