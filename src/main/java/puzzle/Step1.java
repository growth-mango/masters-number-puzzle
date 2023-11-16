package puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 원래보다 간단한 기능의 숫자퍼즐 구현
public class Step1 {
    private static final String TURN_PREFIX = "Turn ";
    private static int turn = 1;

    public static void main(String[] args) {
        System.out.println("간단 숫자 퍼즐");
        turnPrint();

    }

    public static void turnPrint() {
        System.out.println(TURN_PREFIX + turn);
        turn++;
    }

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }


}
