package com.example.tpnotefullstack.controller;

import com.example.tpnotefullstack.service.EmployeeService;
import com.example.tpnotefullstack.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final EmployeeService employeeService;
    private final CandidateService candidateService;

    @Autowired
    public HomeController(EmployeeService employeeService, CandidateService candidateService) {
        this.employeeService = employeeService;
        this.candidateService = candidateService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("employeeCount", employeeService.findAll().size());
        model.addAttribute("candidateCount", candidateService.findAll().size());
        return "index";
    }
}