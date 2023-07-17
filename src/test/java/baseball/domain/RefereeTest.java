package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void setup() {
        referee = new Referee();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,0볼 3스트라이크", "7,8,9,낫싱", "3,1,2,3볼 0스트라이크"})
    void name(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));

        assertThat(actual).isEqualTo(expected);
    }
}