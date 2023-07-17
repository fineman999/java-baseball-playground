package baseball;

public class Ball {
    private final int position;
    private final BallNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new BallNumber(number);
    }


    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (ball.matchNumber(number.getNumber())) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchNumber(int number) {
        return this.number.getNumber() == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number.getNumber() == ball.number.getNumber();
    }

}
