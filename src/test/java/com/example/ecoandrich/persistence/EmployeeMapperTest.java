package com.example.ecoandrich.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Nested
    class 사원_정보_조회 {

        @Test
        void 정상적으로_사원을_조회한다() {
            // when
            EmployeeDetail actual = employeeMapper.findDetailById(100).get();

            // then
            assertThat(actual).hasNoNullFieldsOrProperties();
        }

        @Test
        void 존재하지않는_사원ID이면_empty() {
            // when
            Optional<EmployeeDetail> actual = employeeMapper.findDetailById(-1);

            // then
            assertThat(actual).isEmpty();
        }
    }

    @Nested
    class 사원_이력_조회 {

        @Test
        void 정상적으로_이력을_조회한다() {
            // given
            EmployeeJobHistory actual = employeeMapper.findJobHistoryById(101).get();

            // then
            assertThat(actual.getJobHistories()).hasSize(2);
        }
    }
}
