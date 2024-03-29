package com.example.ecoandrich.api;


import com.example.ecoandrich.api.dto.EmployeeSalaryUpdateRequest;
import com.example.ecoandrich.api.dto.EmployeeUpdateRequest;
import com.example.ecoandrich.persistence.EmployeeMapper;
import com.example.ecoandrich.persistence.dto.EmployeeDetail;
import com.example.ecoandrich.persistence.dto.EmployeeJobHistory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Transactional
@Tag(name = "사원 API")
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    @GetMapping("/{employeeId}")
    @Operation(description = "사원의 ID로 상세정보를 조회한다.")
    public ResponseEntity<EmployeeDetail> getEmployeeDetail(@PathVariable Integer employeeId) {
        EmployeeDetail employeeDetail = employeeMapper.findDetailById(employeeId)
                .orElseThrow(IllegalArgumentException::new);
        return ResponseEntity.ok(employeeDetail);
    }

    @GetMapping("/{employeeId}/job-history")
    @Operation(description = "사원의 ID로 이력을 조회한다.")
    public ResponseEntity<EmployeeJobHistory> getEmployeeJobHistory(@PathVariable Integer employeeId) {
        EmployeeJobHistory employeeJobHistory = employeeMapper.findJobHistoryById(employeeId)
                .orElseThrow(IllegalArgumentException::new);
        return ResponseEntity.ok(employeeJobHistory);
    }

    @PutMapping("/{employeeId}")
    @Operation(description = "사원의 정보를 수정한다.")
    public ResponseEntity<Void> updateEmployeeInformation(
            @PathVariable Integer employeeId,
            @RequestBody @Valid EmployeeUpdateRequest request
    ) {
        employeeMapper.updateById(employeeId, request.toCommand());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/increase-salary")
    @Operation(description = "사원의 부서를 통해 급여를 인상한다")
    public ResponseEntity<Void> increaseSalaryByDepartment(@RequestBody EmployeeSalaryUpdateRequest request) {
        employeeMapper.updateSalaryByDepartmentIdAndRate(
                request.departmentId(),
                getIncreaseRatio(request.increaseRate())
        );

        return ResponseEntity.noContent().build();
    }

    private BigDecimal getIncreaseRatio(BigDecimal percentage) {
        return percentage.divide(new BigDecimal(100)).add(BigDecimal.ONE);
    }
}
