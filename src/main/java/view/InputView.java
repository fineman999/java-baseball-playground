package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private int terminate = 0;


    public List<Integer> askNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String player = scanner.nextLine();
        return Arrays.stream(player.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public void askTerminate() {
        terminate = Integer.parseInt(scanner.nextLine());
    }

    public void close() {
        scanner.close();
    }

    public boolean isTerminate() {
        return terminate != 1;
    }
}
