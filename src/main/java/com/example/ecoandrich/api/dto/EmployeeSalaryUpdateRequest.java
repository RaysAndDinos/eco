package com.example.ecoandrich.api.dto;

import java.math.BigDecimal;

public record EmployeeSalaryUpdateRequest(
        Integer departmentId,
        BigDecimal increaseRate
) {
}
