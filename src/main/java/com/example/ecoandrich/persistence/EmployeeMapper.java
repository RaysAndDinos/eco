package com.example.ecoandrich.persistence;

import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    Optional<EmployeeDetail> findDetailById(Integer employeeId);

    Optional<EmployeeJobHistory> findJobHistoryById(Integer employeeId);
}
