package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CreateBallsTest {

    @Test
    @DisplayName("3개의 수인가?")
    void create() {
        Balls numberGenerator = Balls.create(new ArrayList<>());

        assertThat(numberGenerator.getBalls().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("3개의 수가 다 다른가?")
    void createRandom() {
        Balls numberGenerator = Balls.create(new ArrayList<>());

        List<Ball> balls = numberGenerator.getBalls();

        assertAll(
                () -> assertThat(balls.get(0).getNumber().getNumber()).isNotEqualTo(balls.get(1).getNumber().getNumber()),
                () -> assertThat(balls.get(0).getNumber().getNumber()).isNotEqualTo(balls.get(2).getNumber().getNumber()),
                () -> assertThat(balls.get(1).getNumber().getNumber()).isNotEqualTo(balls.get(2).getNumber().getNumber())
        );
    }

}
