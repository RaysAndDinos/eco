package com.example.ecoandrich.persistence.dto;

import lombok.Getter;

@Getter
public class DepartmentLocationResponse {

    private Integer departmentId;
    private String departmentName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryName;
}
