package baseball.domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player) {
        // 몇 개의 숫자가 같은지 알아낸 뒤
        // 스트라이크의 개수를 구해 뺀다. - 볼의 개수
        // 남은 수는 볼의 개수이다.
        Judgement judgement = new Judgement();
        int correctCount = judgement.correctCount(computer, player);

        int strikeCount = 0;
        for (int placeIndex = 0; placeIndex < computer.size(); placeIndex++) {
            if (judgement.hasPlace(computer, placeIndex, player.get(placeIndex))) {
                strikeCount++;
            }
        }
        int ballCount = correctCount - strikeCount;
        if (strikeCount == 0) {
            return "낫싱";
        }
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }
}
