package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsNumberTest {


    @ParameterizedTest
    @CsvSource({"1","9"})
    @DisplayName("한 자리 수를 생성한다.")
    void validation(int value) {
        BallNumber ballNumber = BallNumber.create(value);

        assertThat(ballNumber.getNumber()).isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource({"0","10"})
    @DisplayName("1~9만큼의 수를 벗어날 시 예외처리가 난다.")
    void validationException(int value) {
        assertThatThrownBy(
                () -> {
                    BallNumber ballNumber = BallNumber.create(value);
                }
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("숫자는 1부터 9까지만 가능합니다.");
    }

}
