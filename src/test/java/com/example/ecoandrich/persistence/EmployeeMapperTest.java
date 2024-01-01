package com.example.ecoandrich.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import com.example.ecoandrich.persistence.dto.EmployeeDetail;
import com.example.ecoandrich.persistence.dto.EmployeeJobHistory;
import com.example.ecoandrich.persistence.dto.EmployeeUpdateCommand;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    @Test
    void 사원_이력을_정상적으로_조회한다() {
        // given
        EmployeeJobHistory actual = employeeMapper.findJobHistoryById(101).get();

        // then
        assertThat(actual.getJobHistories()).hasSize(2);
    }

    @Test
    void 임금_인상을_정상적으로_실행한다() {
        // when && then
        assertThatNoException().isThrownBy(
                () -> employeeMapper.updateSalaryByDepartmentIdAndRate(90, new BigDecimal(1.2))
        );
    }

    @Test
    void 사원_변경을_정상적으로_실행한다() {
        // given
        EmployeeUpdateCommand command = new EmployeeUpdateCommand(
                "junsu",
                "park",
                "parkJunsu@naver.com",
                "010-xxxx-xxxx",
                LocalDate.now(),
                "IT_PROG",
                BigDecimal.ONE,
                new BigDecimal(0.5),
                100,
                100
        );

        // when && then
        assertThatNoException().isThrownBy(
                () -> employeeMapper.updateById(100, command)
        );
    }
}
