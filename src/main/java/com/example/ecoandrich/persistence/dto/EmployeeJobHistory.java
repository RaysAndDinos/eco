package com.example.ecoandrich.persistence.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;

@Getter
public class EmployeeJobHistory {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private List<JobHistoryInformation> jobHistories;
}
