package baseball;

import java.util.Objects;

public class BallNumber {
    private static final int MIN_NO = 1;
    private static final int MAX_NO = 9;

    private final int number;

    private BallNumber(int number) {
        this.number = number;
    }

    public static BallNumber create(int randomNumber) {
        if (randomNumber < MIN_NO || randomNumber > MAX_NO) {
            throw new IllegalArgumentException("숫자는 1부터 9까지만 가능합니다.");
        }
        return new BallNumber(randomNumber);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
