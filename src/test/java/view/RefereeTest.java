package view;

import baseball.BallStatus;
import baseball.PlayResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import baseball.Referee;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    @DisplayName("결과값 출력: 2볼 1스트라이크")
    void answer() {
        // given
        PlayResult playResult = new PlayResult();
        playResult.report(BallStatus.BALL);
        playResult.report(BallStatus.BALL);
        playResult.report(BallStatus.STRIKE);

        // when
        Referee.create(playResult);

        // then
        assertThat(Referee.answer).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("결과값 출력: 낫싱")
    void answer2() {
        // given
        PlayResult playResult = new PlayResult();
        playResult.report(BallStatus.NOTHING);
        playResult.report(BallStatus.NOTHING);
        playResult.report(BallStatus.NOTHING);

        // when
        Referee.create(playResult);

        // then
        assertThat(Referee.answer).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("결과값 출력: 1볼")
    void answer3() {
        // given
        PlayResult playResult = new PlayResult();
        playResult.report(BallStatus.BALL);
        playResult.report(BallStatus.NOTHING);
        playResult.report(BallStatus.NOTHING);

        // when
        Referee.create(playResult);

        // then
        assertThat(Referee.answer).isEqualTo("1볼");
    }

    @Test
    @DisplayName("결과값 출력: 1스트라이크")
    void answer4() {
        // given
        PlayResult playResult = new PlayResult();
        playResult.report(BallStatus.STRIKE);
        playResult.report(BallStatus.NOTHING);
        playResult.report(BallStatus.NOTHING);

        // when
        Referee.create(playResult);

        // then
        assertThat(Referee.answer).isEqualTo("1스트라이크");
    }
}
