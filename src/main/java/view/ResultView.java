package view;

import baseball.Balls;
import baseball.PlayResult;
import baseball.Referee;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private final InputView inputView;

    public ResultView(InputView inputView) {
        this.inputView = inputView;
    }

    public boolean start() {
        Balls computer = Balls.create(new ArrayList<>());
        Referee.answer = "낫싱";
        run(computer);

        System.out.println(Referee.getCongratulation());
        inputView.askTerminate();

        return inputView.isTerminate();
    }

    private void run(Balls computer) {
        while (!Referee.answer.equals("3스트라이크")) {
            System.out.println(computer);
            List<Integer> numbers = inputView.askNumbers();
            Balls user = Balls.createUser(numbers);
            PlayResult play = computer.play(user);
            Referee.create(play);
            System.out.println(Referee.answer);
        }
    }
}
