package baseball;

import java.util.Objects;

public class Ball {
    private final int index;
    private final BallNumber number;

    private Ball(int index, BallNumber number) {
        this.index = index;
        this.number = number;
    }


    public static Ball create(int index, BallNumber number) {
        return new Ball(index, number);
    }

    public int getIndex() {
        return index;
    }

    public BallNumber getNumber() {
        return number;
    }

    public BallStatus play(Ball user) {
        if (this.number.equals(user.getNumber()) && this.index == user.getIndex()) {
            return BallStatus.STRIKE;
        }
        if (this.number.equals(user.getNumber())) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "index=" + index +
                ", number=" + number.getNumber() +
                '}';
    }
}
