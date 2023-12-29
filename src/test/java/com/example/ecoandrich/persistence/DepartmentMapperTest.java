package com.example.ecoandrich.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
@SpringBootTest
class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    void 페이징하여_성공적으로_조회한다() {
        // when
        List<DepartmentLocationResponse> actual = departmentMapper.findAllByPaging(10, 0);

        // then
        assertThat(actual).hasSize(10);
    }

    @Test
    void 빈_페이지를_조회할_수_있다() {
        // when
        List<DepartmentLocationResponse> actual = departmentMapper.findAllByPaging(10, 900);

        // then
        assertThat(actual).isEmpty();
    }
}
