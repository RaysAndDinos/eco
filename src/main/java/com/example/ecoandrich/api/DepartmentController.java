package com.example.ecoandrich.api;


import com.example.ecoandrich.persistence.DepartmentLocationResponse;
import com.example.ecoandrich.persistence.DepartmentMapper;
import jakarta.validation.constraints.Min;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private static final int DEFAULT_PAGE_SIZE = 10;

    private final DepartmentMapper departmentMapper;

    @GetMapping
    public ResponseEntity<List<DepartmentLocationResponse>> getEmployeeDetail(
            @RequestParam(defaultValue = "1") @Min(1) Integer page
    ) {
        List<DepartmentLocationResponse> response = departmentMapper.findAllByPaging(
                DEFAULT_PAGE_SIZE,
                page * DEFAULT_PAGE_SIZE
                );

        if (response.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return ResponseEntity.ok(response);
    }
}
