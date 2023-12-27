package com.example.ecoandrich.service;

import com.example.ecoandrich.dto.PageInformation;
import com.example.ecoandrich.dto.SmallLibraryPublicApiResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SmallLibraryService {

    private static final String URI = "https://api.odcloud.kr/api/15072349/v1/uddi:1b030651-2c17-4cf9-95e2-91b2cf8db66f";
    private static final String SERVICE_KEY = "xJKHamy52wkRUJsNtOcCZlPfuP7IhcxVe4KIxVNHPRHvOHYe6e4V9NeGepg52CqGytM07flmPDpO3Uvt42pDEA==";

    public ResponseEntity<SmallLibraryPublicApiResponse> findAll(PageInformation pageInformation) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity request = new HttpEntity(headers);
        return restTemplate.exchange(getUrl(pageInformation), HttpMethod.GET, request,
                SmallLibraryPublicApiResponse.class);
    }

    private String getUrl(PageInformation pageInformation) {
        return UriComponentsBuilder.fromHttpUrl(URI)
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("page", pageInformation.page())
                .queryParam("perPage", pageInformation.perPage())
                .build()
                .toUriString();
    }
}
