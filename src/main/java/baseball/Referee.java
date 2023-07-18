package baseball;

public class Referee {
    private final PlayResult playResult;

    public static String answer = "낫싱";
    private Referee(PlayResult playResult) {
        this.playResult = playResult;
    }

    public static Referee create(PlayResult playResult) {
        Referee referee = new Referee(playResult);
        answer = referee.calculate();
        return referee;
    }

    private String calculate() {
        if (playResult.isStrike() && playResult.isBall()) {
            return playResult.getBall() + "볼 " + playResult.getStrike() + "스트라이크";
        }
        if (playResult.isStrike()) {
            return playResult.getStrike() + "스트라이크";
        }
        if (playResult.isBall()) {
            return playResult.getBall() + "볼";
        }
        return  "낫싱";
    }

    public static String getCongratulation() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
