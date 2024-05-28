package com.example.tpnotefullstack.controller;

import com.example.tpnotefullstack.model.Absence;
import com.example.tpnotefullstack.model.Employee;
import com.example.tpnotefullstack.model.Leave;
import com.example.tpnotefullstack.service.AbsenceService;
import com.example.tpnotefullstack.service.EmployeeService;
import com.example.tpnotefullstack.service.LeaveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    LeaveService leaveService;

    @Autowired
    AbsenceService absenceService;

    @GetMapping
    public String listEmployees(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "employee/employee";
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee/form";
    }

    @PostMapping()
    public String valideFrom(@Valid @ModelAttribute Employee employee, Model model, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/employees/new";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}")
    public String viewEmployee(@PathVariable("id") Long id, Model model){
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            model.addAttribute("leave", new Leave());
            model.addAttribute("absence", new Absence());
        }
        return "employee/view";
    }

    @GetMapping("/{id}/edit")
    public String editEmployee(@PathVariable("id") Long id, Model model){
        Optional<Employee> employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/form";
    }

    @GetMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
    @PostMapping(value = "/{id}/leaves", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createLeave(@PathVariable("id") Long id, @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            Leave leave = new Leave();
            leave.setStartDate(Date.valueOf(startDate));
            leave.setEndDate(Date.valueOf(endDate));
            leave.setEmployee(employee);
            leaveService.save(leave);
        }
        return "redirect:/employees/" + id;
    }

    @PostMapping(value = "/{id}/absences", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createAbsence(@PathVariable("id") Long id, @RequestParam("absenceDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate absenceDate) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            Absence absence = new Absence();
            absence.setAbsenceDate(Date.valueOf(absenceDate));
            absence.setEmployee(employee);
            absenceService.save(absence);
        }
        return "redirect:/employees/" + id;
    }

}