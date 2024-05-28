package com.example.tpnotefullstack.controller;

import com.example.tpnotefullstack.model.Candidate;
import com.example.tpnotefullstack.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.tpnotefullstack.service.CandidateService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @GetMapping
    public String listCandidates(Model model){
        List<Candidate> candidateList = candidateService.findAll();
        model.addAttribute("candidates", candidateList);
        return "candidate/candidate";
    }

    @GetMapping("/{id}")
    public String viewCandidate(@PathVariable("id") Long id, Model model){
        Candidate candidate = candidateService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid candidate Id:" + id));
        model.addAttribute("candidate", candidate);
        return "candidate/view";
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("candidate", new Candidate());
        return "candidate/form";
    }

    @PostMapping()
    public String valideFrom(@Valid @ModelAttribute Candidate candidate, Model model, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/candidates/new";
        }
        candidateService.save(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/{id}/edit")
    public String editCandidate(@PathVariable("id") Long id, Model model){
        Optional<Candidate> candidate = candidateService.findById(id);
        model.addAttribute("candidate", candidate);
        return "candidate/form";
    }

    @GetMapping("/{id}/delete")
    public String deleteCandidate(@PathVariable("id") Long id){
        candidateService.deleteById(id);
        return "redirect:/candidates";
    }

}
