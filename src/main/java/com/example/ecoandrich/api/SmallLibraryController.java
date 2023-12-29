package com.example.ecoandrich.api;

import com.example.ecoandrich.dto.PageInformation;
import com.example.ecoandrich.dto.SmallLibraryPublicApiResponse;
import com.example.ecoandrich.service.SmallLibraryService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/small-library")
@RequiredArgsConstructor
public class SmallLibraryController {

    private final SmallLibraryService smallLibraryService;

    @GetMapping
    public ResponseEntity<SmallLibraryPublicApiResponse> find(
            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "10") @Min(10) Integer pageSize
    ) {
        SmallLibraryPublicApiResponse response = smallLibraryService.findAll(new PageInformation(page, pageSize))
                .getBody();
        return ResponseEntity.ok(response);
    }
}
