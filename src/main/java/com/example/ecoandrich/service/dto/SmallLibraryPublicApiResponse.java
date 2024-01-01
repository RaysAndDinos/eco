package com.example.ecoandrich.service.dto;


import java.util.List;

public record SmallLibraryPublicApiResponse(
        Integer page,
        Integer perPage,
        Integer totalCount,
        Integer currentCount,
        Integer matchCount,
        List<SmallLibraryInformation> data
) {

    public record SmallLibraryInformation(
            Integer 평가년도,
            String 도서관구분,
            String 면적,
            String 시군구,
            Integer 장서수,
            Integer 방문자수,
            Integer 대출자수
    ) {

    }
}

