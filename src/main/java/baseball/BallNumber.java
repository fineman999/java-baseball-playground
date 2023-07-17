package baseball;

public class BallNumber {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    private final int number;


    public int getNumber() {
        return number;
    }

    public BallNumber(int number) {
        if (number < MIN_NO || number > MAX_NO) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야 한다.");
        }
        this.number = number;
    }
}
