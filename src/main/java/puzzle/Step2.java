package puzzle;

import java.util.*;

public class Step2 {
    private static final String TURN_PREFIX = "Turn ";
    private static int turn = 1;

    public static void main(String[] args) {
        System.out.println("재미있는 15 퍼즐!\n");
        turnNumber();

    }

    // turn의 숫자를 1부터 증가시키기
    public static void turnNumber() {
        System.out.println(TURN_PREFIX + turn);
        turn++;
    }

    // 랜덤 숫자 생성하기 // 1부터 15까지 // [] 포함 // 4 * 4 형식 //
//    public static List<Integer> generateNumbers(){
//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 1; i <= 15 ; i++) {
//            numbers.add(i);
//        }
//        Collections.shuffle(numbers);
//        return numbers;
//    }



}
