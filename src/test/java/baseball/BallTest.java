package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }


    @Test
    @DisplayName("숫자 값이 다른 경우 - 낫싱")
    void nothing() {

        BallStatus status = com.play(new Ball(2, 5));

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("위치는 다른데 숫자 값이 같은 경우 - 볼")
    void ball() {

        BallStatus status = com.play(new Ball(2, 4));

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("위치와 숫자 값이 같은 경우 - 스트라이크")
    void strike() {

        BallStatus status = com.play(new Ball(1, 4));

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }


}
