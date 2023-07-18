import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        boolean check = false;
        InputView inputView = new InputView();
        while (!check) {
            ResultView resultView = new ResultView(inputView);
            check = resultView.start();
        }
        System.out.println("--------------");
        inputView.close();
    }
}
