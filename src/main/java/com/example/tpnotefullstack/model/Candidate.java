package com.example.tpnotefullstack.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
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

    @NotEmpty(message = "Domain is required")
    private String domain;

    @Min(value = 1, message = "Grade must be equal or greater than 1")
    @Max(value = 10, message = "Grade must be equal or less than 10")
    private int grade;

    @NotNull(message = "Date of job meeting is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfJobMeeting;

    @NotEmpty(message = "Observation is required")
    private String observation;
}
