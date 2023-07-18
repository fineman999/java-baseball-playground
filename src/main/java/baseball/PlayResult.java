package baseball;

public class PlayResult {

    private int strike = 0;
    private int ball = 0;
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            this.strike++;
        }
        if (ballStatus.isBall()) {
            this.ball++;
        }
    }

    public boolean isStrike() {
        return strike > 0;
    }
    public boolean isBall() {
        return ball > 0;
    }
}
