package com.example.ecoandrich.persistence;

import java.math.BigDecimal;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    Optional<EmployeeDetail> findDetailById(Integer employeeId);

    Optional<EmployeeJobHistory> findJobHistoryById(Integer employeeId);

    void updateById(Integer employeeId, EmployeeUpdateCommand command);

    void updateSalaryByDepartmentIdAndRate(Integer departmentId, BigDecimal rate);
}
