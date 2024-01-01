package com.example.ecoandrich.api;

import com.example.ecoandrich.persistence.EmployeeUpdateCommand;
import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeUpdateRequest(
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

    public EmployeeUpdateCommand toCommand() {
        return new EmployeeUpdateCommand(
                firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commissionPct, managerId, departmentId
        );
    }

}


