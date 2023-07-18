package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    @DisplayName("숫자 값이 다른 경우 - 낫싱")
    void nothing() {
        // given
        int comIndex = 0;
        BallNumber comNumber = BallNumber.create(1);
        int userIndex = 1;
        BallNumber userNumber = BallNumber.create(2);

        Ball computer = Ball.create(comIndex, comNumber);
        Ball user = Ball.create(userIndex, userNumber);

        // when
        BallStatus status = computer.play(user);

        // then
        Assertions.assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("숫자 값이 같고, 위치가 다른 경우 - 볼")
    void ball() {
        // given
        int comIndex = 0;
        BallNumber comNumber = BallNumber.create(1);
        int userIndex = 1;
        BallNumber userNumber = BallNumber.create(1);

        Ball computer = Ball.create(comIndex, comNumber);
        Ball user = Ball.create(userIndex, userNumber);

        // when
        BallStatus status = computer.play(user);

        // then
        Assertions.assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("숫자 값이 같고, 위치가 같을 경우 - 스트라이크")
    void strike() {
        // given
        int comIndex = 0;
        BallNumber comNumber = BallNumber.create(1);
        int userIndex = 0;
        BallNumber userNumber = BallNumber.create(1);

        Ball computer = Ball.create(comIndex, comNumber);
        Ball user = Ball.create(userIndex, userNumber);

        // when
        BallStatus status = computer.play(user);

        // then
        Assertions.assertThat(status).isEqualTo(BallStatus.STRIKE);
    }


}
