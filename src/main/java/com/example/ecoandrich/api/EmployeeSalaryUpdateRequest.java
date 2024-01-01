package com.example.ecoandrich.api;

import java.math.BigDecimal;

public record EmployeeSalaryUpdateRequest(
        Integer departmentId,
        BigDecimal increaseRate
) {
}
