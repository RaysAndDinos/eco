package com.example.ecoandrich.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeUpdateCommand(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        LocalDate hireDate,
        String jobId,
        BigDecimal salary,
        BigDecimal commissionPct,
        Integer managerId,
        Integer departmentId
) {

}


