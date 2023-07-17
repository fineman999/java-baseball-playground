package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);

    @Test
    @DisplayName("3 스트라이크")
    void compare() {
        Referee referee = new Referee();

        String result = referee.compare(ANSWER, Arrays.asList(1, 2, 3));

        assertThat(result).isEqualTo("0볼 3스트라이크");
    }

    @Test
    @DisplayName("out")
    void out() {
        Referee referee = new Referee();

        String result = referee.compare(ANSWER, Arrays.asList(4, 5, 6));

        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("3볼")
    void ball() {
        Referee referee = new Referee();

        String result = referee.compare(ANSWER, Arrays.asList(3, 1, 2));

        assertThat(result).isEqualTo("3볼 0스트라이크");
    }





}