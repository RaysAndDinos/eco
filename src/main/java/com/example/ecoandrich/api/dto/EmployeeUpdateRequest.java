package com.example.ecoandrich.api.dto;

import com.example.ecoandrich.persistence.dto.EmployeeUpdateCommand;
import jakarta.validation.constraints.DecimalMax;
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
        @DecimalMax(value = "1", inclusive = false)
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


