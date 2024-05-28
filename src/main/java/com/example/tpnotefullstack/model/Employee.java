package com.example.tpnotefullstack.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Id number is required")
    private String numId;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "Email is required")
    private String email;

    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotEmpty(message = "Phone is required")
    private String phone;

    @NotEmpty(message = "Position is required")
    private String position;

    @Min(value = 1, message = "Salary must be equal or greater than 1")
    private Double salary;

    @NotNull(message = "Date of start job is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfStartJob;

    @NotNull(message = "Date of end job is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfEndJob;

    @NotEmpty(message = "Observation is required")
    private String observation;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Leave> leaves;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Absence> absences;
}
