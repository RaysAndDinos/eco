package com.example.ecoandrich.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.ecoandrich.dto.PageInformation;
import com.example.ecoandrich.dto.SmallLibraryPublicApiResponse;
import com.example.ecoandrich.dto.SmallLibraryPublicApiResponse.SmallLibraryInformation;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
@SpringBootTest
class SmallLibraryServiceTest {

    @Autowired
    private SmallLibraryService smallLibraryService;

    @Test
    void 공공데이터_API를_정상적으로_호출한다() {
        // given
        PageInformation page = new PageInformation(1, 10);

        // when
        ResponseEntity<SmallLibraryPublicApiResponse> response = smallLibraryService.findAll(page);

        // then
        int actual = response.getStatusCode().value();
        assertThat(actual).isEqualTo(200);
    }

    @Test
    void 데이터가_매핑된다() {
        // given
        PageInformation page = new PageInformation(1, 10);

        // when
        ResponseEntity<SmallLibraryPublicApiResponse> response = smallLibraryService.findAll(page);


        // then
        SmallLibraryPublicApiResponse actual = response.getBody();
        assertAll(
                () -> assertThat(actual).hasNoNullFieldsOrProperties(),
                () -> assertThat(actual.data())
                        .allSatisfy(it -> assertThat(it).hasNoNullFieldsOrProperties())
        );
    }

    @Test
    void 페이징을_통해_원하는_갯수만큼_반환한다() {
        // given
        PageInformation page = new PageInformation(1, 100);

        // when
        ResponseEntity<SmallLibraryPublicApiResponse> response = smallLibraryService.findAll(page);

        // then
        List<SmallLibraryInformation> actual = response.getBody().data();
        assertThat(actual).hasSize(100);
    }
}
