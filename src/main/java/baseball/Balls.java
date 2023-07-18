package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Balls {
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }
    public static Balls create(List<Ball> numbers) {
        while (numbers.size() < 3) {
            BallNumber ballNumber = BallNumber.create(new Random().nextInt(9) + 1);
            Ball ball = Ball.create(numbers.size(), ballNumber);
            if (!numbers.contains(ball)) {
                numbers.add(ball);
            }
        }
        return new Balls(numbers);
    }
    public static Balls createUser(List<Integer> numbers) {
        List<Ball> newBalls = new ArrayList<>();
        for (Integer number : numbers) {
            BallNumber ballNumber = BallNumber.create(number);
            Ball ball = Ball.create(numbers.indexOf(number), ballNumber);
            newBalls.add(ball);
        }
        return new Balls(newBalls);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public PlayResult play(Balls user) {
        PlayResult playResult = new PlayResult();

        for (Ball ball : balls) {
            BallStatus status = user.play(ball);
            playResult.report(status);
        }
        return playResult;
    }

    private BallStatus play(Ball ball) {
        return balls.stream()
                .map(ball::play)
                .filter(BallStatus::isNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    @Override
    public String toString() {
        return "Balls{" +
                "balls=" + balls +
                '}';
    }
}
