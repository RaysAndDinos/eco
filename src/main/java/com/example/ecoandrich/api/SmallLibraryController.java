package com.example.ecoandrich.api;

import com.example.ecoandrich.service.SmallLibraryService;
import com.example.ecoandrich.service.dto.PageInformation;
import com.example.ecoandrich.service.dto.SmallLibraryPublicApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "작은 도서관(공공 데이터 API) 정보 요청")
public class SmallLibraryController {

    private final SmallLibraryService smallLibraryService;

    @GetMapping
    @Operation(description = "작은도서관 정보를 페이징하여 조회한다.")
    public ResponseEntity<SmallLibraryPublicApiResponse> find(
            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "10") @Min(10) Integer pageSize
    ) {
        SmallLibraryPublicApiResponse response = smallLibraryService.findAll(new PageInformation(page, pageSize))
                .getBody();
        return ResponseEntity.ok(response);
    }
}
