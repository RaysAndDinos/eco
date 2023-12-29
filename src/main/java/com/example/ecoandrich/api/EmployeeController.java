package com.example.ecoandrich.api;


import com.example.ecoandrich.persistence.EmployeeDetail;
import com.example.ecoandrich.persistence.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDetail> getEmployeeDetail(@PathVariable Integer employeeId) {
        EmployeeDetail employeeDetail = employeeMapper.findDetailById(employeeId)
                .orElseThrow(IllegalArgumentException::new);
        return ResponseEntity.ok(employeeDetail);
    }
}
