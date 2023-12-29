package com.example.ecoandrich.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class EmployeeDetail {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private BigDecimal salary;
    private BigDecimal commissionPct = BigDecimal.ZERO;
    private String departmentName;
    private String jobTitle;
}
