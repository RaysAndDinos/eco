package com.example.ecoandrich.api;


import com.example.ecoandrich.persistence.EmployeeDetail;
import com.example.ecoandrich.persistence.EmployeeJobHistory;
import com.example.ecoandrich.persistence.EmployeeMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Tag(name = "사원 정보 요청")
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
}
