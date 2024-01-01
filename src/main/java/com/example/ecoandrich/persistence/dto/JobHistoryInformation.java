package com.example.ecoandrich.persistence.dto;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class JobHistoryInformation {
    private String jobTitle;
    private LocalDate startDate;
    private LocalDate endDate;
}
