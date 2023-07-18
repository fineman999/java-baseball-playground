package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BallsTest {

    private Balls computerBalls;

    @BeforeEach
    void setUp() {
        int comIndex = 0;
        BallNumber comNumber = BallNumber.create(1);
        Ball ball = Ball.create(comIndex, comNumber);

        int comIndex2 = 1;
        BallNumber comNumber2 = BallNumber.create(2);
        Ball ball2 = Ball.create(comIndex2, comNumber2);

        int comIndex3 = 2;
        BallNumber comNumber3 = BallNumber.create(3);
        Ball ball3 = Ball.create(comIndex3, comNumber3);

        computerBalls = Balls.create(Arrays.asList(ball, ball2, ball3));

    }

    @Test
    @DisplayName("숫자 값이 다른 경우 - 낫싱")
    void nothing() {
        // given
        int userIndex = 0;
        BallNumber userNumber = BallNumber.create(4);
        Ball ball = Ball.create(userIndex, userNumber);

        int userIndex1 = 1;
        BallNumber userNumber1 = BallNumber.create(5);
        Ball ball1 = Ball.create(userIndex1, userNumber1);

        int userIndex2 = 2;
        BallNumber userNumber2 = BallNumber.create(6);
        Ball ball2 = Ball.create(userIndex2, userNumber2);

        Balls userBalls = Balls.create(Arrays.asList(ball, ball1, ball2));


        // when
        PlayResult result = computerBalls.play(userBalls);

        // then
        assertAll(
            () -> assertThat(result.getStrike()).isEqualTo(0),
            () -> assertThat(result.getBall()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("숫자 값이 같고, 위치가 다른 경우 - 볼")
    void ball() {
        // given
        int userIndex = 0;
        BallNumber userNumber = BallNumber.create(2);
        Ball ball = Ball.create(userIndex, userNumber);

        int userIndex1 = 1;
        BallNumber userNumber1 = BallNumber.create(3);
        Ball ball1 = Ball.create(userIndex1, userNumber1);

        int userIndex2 = 2;
        BallNumber userNumber2 = BallNumber.create(1);
        Ball ball2 = Ball.create(userIndex2, userNumber2);

        Balls userBalls = Balls.create(Arrays.asList(ball, ball1, ball2));

        // when
        PlayResult result = computerBalls.play(userBalls);

        // then
        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(0),
                () -> assertThat(result.getBall()).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("숫자 값이 같고, 위치가 같은 경우 - 스트라이크")
    void strike() {
        // given
        int userIndex = 0;
        BallNumber userNumber = BallNumber.create(1);
        Ball ball = Ball.create(userIndex, userNumber);

        int userIndex1 = 1;
        BallNumber userNumber1 = BallNumber.create(2);
        Ball ball1 = Ball.create(userIndex1, userNumber1);

        int userIndex2 = 2;
        BallNumber userNumber2 = BallNumber.create(3);
        Ball ball2 = Ball.create(userIndex2, userNumber2);

        Balls userBalls = Balls.create(Arrays.asList(ball, ball1, ball2));

        // when
        PlayResult result = computerBalls.play(userBalls);

        // then
        assertAll(
                () -> assertThat(result.getStrike()).isEqualTo(3),
                () -> assertThat(result.getBall()).isEqualTo(0)
        );
    }
}
